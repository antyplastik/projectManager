package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.user.domain.UserDto;

import java.util.List;

public interface ProjectCrudInterface {

    boolean addProject(ProjectDto projectDto, UserDto adminLogin);

    ProjectDto findProject(ProjectDto projectDto);

    List<ProjectDto> findProjects(ProjectDto projectDto);

    boolean isProjectExist(ProjectDto projectDto);

    boolean updateProject(ProjectDto newProject, ProjectDto oldDto, UserDto adminLogin);

    boolean deleteProject(ProjectDto projectDto);

    static ProjectDto map(ProjectEntity entity) {
        return ProjectMapper.map(entity);
    }

    static ProjectEntity map(ProjectDto dto) {
        return ProjectMapper.map(dto);
    }
}
