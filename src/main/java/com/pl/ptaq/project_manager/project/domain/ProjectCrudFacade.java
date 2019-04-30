package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.user.domain.UserDto;

import java.util.List;

public interface ProjectCrudFacade {

    boolean addProject(String projectCode, String projectName, String teamId, String projectDescription, UserDto adminLogin);

    ProjectDto findProject(String projectCode, String projectName);

    List<ProjectDto> findProjects(String teamId, String projectName, String projectDescription);

    boolean isProjectExist(String projectCode, String projectName);

    boolean updateProject(String projectCode, String projectName, String teamId, String projectDescription, UserDto adminLogin);

    boolean deleteProject(String projectCode);

    static ProjectDto map(ProjectEntity entity) {
        return null;
    }

    static ProjectEntity map(ProjectDto dto) {
        return null;
    }
}
