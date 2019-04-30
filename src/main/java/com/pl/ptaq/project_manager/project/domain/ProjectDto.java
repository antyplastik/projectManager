package com.pl.ptaq.project_manager.project.domain;

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

    @NotNull
    private String teamId;

    @NotNull
    private String projectDescription;

    @NotNull
    private UserDto adminLogin;

}
