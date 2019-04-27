package com.pl.ptaq.project_manager.project.domain;

class ProjectMapper {

    public static ProjectDto map(ProjectEntity entity) {
        if (entity != null)
            return new ProjectDto().builder()
                    .projectCode(entity.getProjectCode())
                    .projectName(entity.getProjectName())
                    .teamId(entity.getTeamId())
                    .projectDescription(entity.getProjectDescription())
                    .adminLogin(entity.getAdminLogin())
                    .build();
        return null;
    }

    public static ProjectEntity map(ProjectDto projectDto) {
        if (projectDto != null)
            return new ProjectEntity().builder()
                    .projectCode(projectDto.getProjectCode())
                    .projectName(projectDto.getProjectName())
                    .teamId(projectDto.getTeamId())
                    .projectDescription(projectDto.getProjectDescription())
                    .adminLogin(projectDto.getAdminLogin())
                    .build();
        return null;
    }
}
