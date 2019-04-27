package com.pl.ptaq.project_manager.project.domain;

import java.util.List;

public interface ProjectCrudFacade {

    boolean addProject(String projectCode, String projectName, String teamId, String projectDescription, String adminLogin);

    ProjectDto findProject(String projectCode, String projectName);

    List<ProjectDto> findProjects(String teamId, String projectName, String projectDescription);

    boolean isProjectExist(String projectCode, String projectName);

    boolean updateProject(String projectCode, String projectName, String teamId, String projectDescription, String adminLogin);

    boolean deleteProject(String projectCode);
}
