package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.team.TeamDto;
import com.pl.ptaq.project_manager.team.TeamEntity;
import com.pl.ptaq.project_manager.user.domain.UserDto;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
public class ProjectDto {

    @NotNull
    private String projectCode;

    @NotNull
    private String projectName;


    private TeamDto team;

    @NotNull
    private String projectDescription;


    private UserDto projectManager;

}
