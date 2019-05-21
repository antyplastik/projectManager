package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.team.TeamCrudInterface;
import com.pl.ptaq.project_manager.user.domain.UserCrudInterface;

class ProjectMapper {

    public static ProjectDto map(ProjectEntity entity) {
        if (entity != null)
            return new ProjectDto().builder()
                    .projectCode(entity.getProjectCode())
                    .projectName(entity.getProjectName())
                    .team(TeamCrudInterface.map(entity.getTeam()))
                    .projectDescription(entity.getProjectDescription())
                    .projectManager(UserCrudInterface.map(entity.getProjectManager()))
                    .build();
        return null;
    }

    public static ProjectEntity map(ProjectDto projectDto) {
        if (projectDto != null)
            return new ProjectEntity().builder()
                    .projectCode(projectDto.getProjectCode())
                    .projectName(projectDto.getProjectName())
                    .team(TeamCrudInterface.map(projectDto.getTeam()))
                    .projectDescription(projectDto.getProjectDescription())
                    .projectManager(UserCrudInterface.map(projectDto.getProjectManager()))
                    .build();
        return null;
    }
}
