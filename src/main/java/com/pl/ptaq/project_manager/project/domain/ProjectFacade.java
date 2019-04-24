package com.pl.ptaq.project_manager.project.domain;

public interface ProjectFacade {

    boolean addProject();

    ProjectDto findProject();

    boolean isProjectExist();

    boolean updateProject();

    boolean deleteProject();
}
