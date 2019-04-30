package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.user.domain.UserCrudService;
import com.pl.ptaq.project_manager.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectCrudService implements ProjectCrudFacade {

    private final ProjectRepository repository;

    @Autowired
    public ProjectCrudService(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addProject(String projectCode, String projectName, String teamId, String projectDescription, UserDto adminLogin) {
        ProjectEntity project;
        if (!isProjectExist(projectCode, projectName)) {
            project = new ProjectEntity().builder()
                    .projectCode(projectCode)
                    .projectName(projectName)
                    .teamId(teamId)
                    .projectDescription(projectDescription)
                    .adminLogin(UserCrudService.map(adminLogin))
                    .build();

            repository.save(project);

            return isProjectExist(project.getProjectCode(), project.getProjectName());
        }
        return false;
    }

    private ProjectEntity findProjectEntityByCode(String projectCode) {
        return repository.findByProjectCode(projectCode);
    }

    private ProjectEntity findProjectEntityByName(String projectName) {
        return repository.findByProjectName(projectName);
    }

    private ProjectEntity findProjectEntity(String projectCode, String projectName) {
        if (projectCode != null)
            return findProjectEntityByCode(projectCode);
        else
            return findProjectEntityByName(projectName);
    }

    @Override
    public ProjectDto findProject(String projectCode, String projectName) {
        if (projectCode != null)
            return ProjectMapper.map(findProjectEntityByCode(projectCode));
        else
            return ProjectMapper.map(findProjectEntityByName(projectName));
    }

    private List<ProjectDto> addToResultList(List<ProjectDto> resultList, List<ProjectEntity> input) {
        for (ProjectEntity entity : input)
            resultList.add(ProjectMapper.map(entity));

        return resultList;
    }

    @Override
    public List<ProjectDto> findProjects(String teamId, String projectName, String projectDescription) {
        List<ProjectDto> resultList = new ArrayList<ProjectDto>();

        if (teamId != null)
            resultList = addToResultList(resultList, repository.findAllByTeamId(teamId));

        if (projectDescription != null)
            resultList = addToResultList(resultList,
                    repository.findAllByProjectDescriptionLike(projectDescription));

        if (projectName != null)
            resultList = addToResultList(resultList,
                    repository.findAllByProjectNameLike(projectName));

        return resultList;
    }

    @Override
    public boolean isProjectExist(String projectCode, String projectName) {
        if (projectCode != null || projectName != null) {
            return findProject(projectCode, projectName) != null;
        }
        return false;
    }

    @Override
    public boolean updateProject(String projectCode, String projectName, String teamId, String projectDescription, UserDto adminLogin) {
        ProjectEntity found = findProjectEntity(projectCode, projectName);

        if (found != null) {
            ProjectEntity modified = new ProjectEntity();
            modified.setProjectId(found.getProjectId());

            if (projectCode != null)
                modified.setProjectCode(projectCode);
            if (projectName != null)
                modified.setProjectName(projectName);
            if (teamId != null)
                modified.setTeamId(teamId);
            if (projectDescription != null)
                modified.setProjectDescription(projectDescription);
            if (adminLogin != null)
                modified.setAdminLogin(UserCrudService.map(adminLogin));

            if  (modified.hashCode() != found.hashCode()){
                repository.save(modified);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProject(String projectCode) {
        ProjectEntity found = findProjectEntityByCode(projectCode);
        if (found != null) {
            repository.delete(found);
            return !isProjectExist(found.getProjectCode(), found.getProjectName());
        }
        return false;
    }


    public ProjectDto map(ProjectEntity entity) {
        return ProjectMapper.map(entity);
    }


    public ProjectEntity map(ProjectDto dto) {
        return ProjectMapper.map(dto);
    }
}
