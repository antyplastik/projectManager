package com.pl.ptaq.project_manager.task.domain;

import com.pl.ptaq.project_manager.sprint.SprintDto;
import com.pl.ptaq.project_manager.user.domain.UserDto;
import org.joda.time.DateTime;

import java.util.List;
import java.util.stream.Collectors;

public interface TaskCrudInterface {

    boolean create(TaskDto taskDto);

    TaskDto read(SprintDto sprintDto, String topic);

    boolean isExist(TaskDto taskDto);

    boolean update(TaskDto taskDto);

    boolean delete(TaskDto taskDto);

    static TaskDto map(TaskEntity entity) {
        return TaskMapper.map(entity);
    }

    static TaskEntity map(TaskDto dto) {
        return TaskMapper.map(dto);
    }

    static List<TaskDto> mapDtoList(List<TaskEntity> entities) {
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    static List<TaskEntity> mapEntityList(List<TaskDto> dtos) {
        return dtos.stream()
                .map(dto -> map(dto))
                .collect(Collectors.toList());
    }
}
