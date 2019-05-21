package com.pl.ptaq.project_manager.sprint;

import com.pl.ptaq.project_manager.project.domain.ProjectCrudInterface;

import java.util.List;
import java.util.stream.Collectors;

class SprintMapper {

    public static SprintDto map(SprintEntity entity) {
        if (entity != null)
            return new SprintDto().builder()
                    .project(ProjectCrudInterface.map(entity.getProject()))
                    .sprintName(entity.getSprintName())
                    .startDate(entity.getStartDate())
                    .stopDate(entity.getStopDate())
                    .burn(entity.getBurn())
                    .build();
        else
            return null;
    }

    public static SprintEntity map(SprintDto dto) {
        if (dto != null)
            return new SprintEntity().builder()
                    .project(ProjectCrudInterface.map(dto.getProject()))
                    .sprintName(dto.getSprintName())
                    .startDate(dto.getStartDate())
                    .stopDate(dto.getStopDate())
                    .burn(dto.getBurn())
                    .build();
        else
            return null;
    }


    public static List<SprintDto> mapDtoList(List<SprintEntity> entities) {
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    public static List<SprintEntity> mapEntityList(List<SprintDto> dtos) {
        return dtos.stream()
                .map(dto -> map(dto))
                .collect(Collectors.toList());
    }
}
