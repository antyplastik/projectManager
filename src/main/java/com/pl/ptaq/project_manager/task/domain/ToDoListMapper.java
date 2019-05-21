package com.pl.ptaq.project_manager.task.domain;

import java.util.List;
import java.util.stream.Collectors;

class ToDoListMapper {

    public static ToDoListDto map(ToDoListEntity entity) {
        if (entity != null)
            return new ToDoListDto().builder()
                    .rowDescription(entity.getRowDescription())
                    .isDone(entity.isDone())
                    .modificationTime(entity.getModificationTime())
                    .build();
        else
            return null;
    }

    public static ToDoListEntity map(ToDoListDto dto) {
        if (dto != null)
            return new ToDoListEntity().builder()
                    .rowDescription(dto.getRowDescription())
                    .isDone(dto.isDone())
                    .modificationTime(dto.getModificationTime())
                    .build();
        else
            return null;
    }

    public static List<ToDoListDto> mapDtoList(List<ToDoListEntity> entities) {
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    public static List<ToDoListEntity> mapEntityList(List<ToDoListDto> dtos) {
        return dtos.stream()
                .map(dto -> map(dto))
                .collect(Collectors.toList());
    }
}
