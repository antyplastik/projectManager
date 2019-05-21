package com.pl.ptaq.project_manager.sprint;

import com.pl.ptaq.project_manager.project.domain.ProjectDto;
import lombok.*;
import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
public class SprintDto {

    private ProjectDto project;

    private String sprintName;

    private DateTime startDate;

    private DateTime stopDate;

    private Double burn;
}
