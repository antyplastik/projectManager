package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.team.TeamCrudInterface;
import com.pl.ptaq.project_manager.user.domain.UserCrudInterface;
import com.pl.ptaq.project_manager.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectCrudService implements ProjectCrudInterface {

    private ProjectRepository projectRepository;

    private UserCrudInterface userCrudFacade;

    @Autowired
    public ProjectCrudService(ProjectRepository projectRepository, UserCrudInterface userCrudFacade) {
        this.projectRepository = projectRepository;
        this.userCrudFacade = userCrudFacade;
    }

    @Override
    public boolean addProject(ProjectDto projectDto, UserDto adminLogin) {
        ProjectEntity entity;
        if (!isProjectExist(projectDto)) {
            entity = new ProjectEntity().builder()
                    .projectCode(projectDto.getProjectCode())
                    .projectName(projectDto.getProjectName())
                    .team(TeamCrudInterface.map(projectDto.getTeam()))
                    .projectDescription(projectDto.getProjectDescription())
                    .projectManager(UserCrudInterface.map(adminLogin))
                    .build();

            return projectRepository.save(entity) != null;
        }
        return false;
    }

    private ProjectEntity findProjectEntityByCode(ProjectDto projectDto) {
        return projectRepository.findByProjectCode(projectDto.getProjectCode());
    }

    private ProjectEntity findProjectEntityByName(ProjectDto projectDto) {
        return projectRepository.findByProjectName(projectDto.getProjectName());
    }

    private ProjectEntity findProjectEntity(ProjectDto dto) {
        if (dto.getProjectCode() != null)
            return findProjectEntityByCode(dto);
        else
            return findProjectEntityByName(dto);
    }

    @Override
    public ProjectDto findProject(ProjectDto projectDto) {
        if (projectDto.getProjectCode() != null)
            return ProjectMapper.map(findProjectEntityByCode(projectDto));
        else
            return ProjectMapper.map(findProjectEntityByName(projectDto));
    }

    @Override
    public List<ProjectDto> findProjects(ProjectDto projectDto) {
        List<ProjectDto> resultList = new ArrayList<ProjectDto>();

        if (projectDto.getTeam() != null)
            resultList = addToResultList(resultList, projectRepository.findAllByTeam(TeamCrudInterface.map(projectDto.getTeam())));

        if (projectDto.getProjectDescription() != null)
            resultList = addToResultList(resultList,
                    projectRepository.findAllByProjectDescriptionLike(projectDto.getProjectDescription()));

        if (projectDto.getProjectName() != null)
            resultList = addToResultList(resultList,
                    projectRepository.findAllByProjectNameLike(projectDto.getProjectName()));

        return resultList;
    }

    private List<ProjectDto> addToResultList(List<ProjectDto> resultList, List<ProjectEntity> input) {
        for (ProjectEntity entity : input)
            resultList.add(ProjectMapper.map(entity));

        return resultList;
    }

    @Override
    public boolean isProjectExist(ProjectDto projectDto) {
        String projectCode = projectDto.getProjectCode();
        String projectName = projectDto.getProjectName();

        if (projectCode != null || projectName != null) {
            return findProject(projectDto) != null;
        }
        return false;
    }

    @Override
    public boolean updateProject(ProjectDto newProjectDto, ProjectDto oldProjectDto, UserDto userDto) {
        String projectCode = newProjectDto.getProjectCode();
        String projectName = newProjectDto.getProjectName();
        String projectDescription = newProjectDto.getProjectDescription();
        ProjectEntity found = findProjectEntity(oldProjectDto);

        if (found != null) {
            ProjectEntity modified = new ProjectEntity();


            if (projectCode != null)
                modified.setProjectCode(projectCode);
            if (projectName != null)
                modified.setProjectName(projectName);
            if (projectDescription != null)
                modified.setProjectDescription(projectDescription);

            if (modified.hashCode() != found.hashCode())
                return projectRepository.save(modified) != null;
        }
        return false;
    }

    @Override
    public boolean deleteProject(ProjectDto projectDto) {
        ProjectEntity found = findProjectEntityByCode(projectDto);
        if (found != null) {
            projectRepository.delete(found);
            return true;
        }
        return false;
    }


    public static ProjectDto map(ProjectEntity entity) {
        return ProjectMapper.map(entity);
    }


    public static ProjectEntity map(ProjectDto dto) {
        return ProjectMapper.map(dto);
    }
}
