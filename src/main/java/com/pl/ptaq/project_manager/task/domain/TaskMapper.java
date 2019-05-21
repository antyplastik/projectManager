package com.pl.ptaq.project_manager.task.domain;

import com.pl.ptaq.project_manager.sprint.SprintCrudInterface;
import com.pl.ptaq.project_manager.user.domain.UserCrudInterface;

import java.util.List;
import java.util.stream.Collectors;

class TaskMapper {

    public static TaskDto map(TaskEntity entity) {
        if (entity != null)
            return new TaskDto().builder()
                    .sprint(SprintCrudInterface.map(entity.getSprint()))
                    .topic(entity.getTopic())
                    .users(UserCrudInterface.mapDtoList(entity.getUsers()))
                    .toDoList(ToDoListCrudInterface.mapDtoList(entity.getToDoList()))
                    .description(entity.getDescription())
                    .creationTime(entity.getCreationTime())
                    .doneTime(entity.getDoneTime())
                    .modificationTime(entity.getModificationTime())
                    .isDone(entity.isDone())
                    .build();
        else
            return null;
    }

    public static TaskEntity map(TaskDto dto) {
        if (dto != null)
            return new TaskEntity().builder()
                    .sprint(SprintCrudInterface.map(dto.getSprint()))
                    .topic(dto.getTopic())
                    .users(UserCrudInterface.mapEntityList((dto.getUsers())))
                    .toDoList(ToDoListCrudInterface.mapEntityList(dto.getToDoList()))
                    .description(dto.getDescription())
                    .creationTime(dto.getCreationTime())
                    .doneTime(dto.getDoneTime())
                    .modificationTime(dto.getModificationTime())
                    .isDone(dto.isDone())
                    .build();
        else
            return null;
    }

    public static List<TaskDto> mapDtoList(List<TaskEntity> entities) {
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    public static List<TaskEntity> mapEntityList(List<TaskDto> dtos) {
        return dtos.stream()
                .map(dto -> map(dto))
                .collect(Collectors.toList());
    }
}
