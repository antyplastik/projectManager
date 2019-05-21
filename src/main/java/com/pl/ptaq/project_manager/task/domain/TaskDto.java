package com.pl.ptaq.project_manager.task.domain;

import com.pl.ptaq.project_manager.sprint.SprintDto;
import com.pl.ptaq.project_manager.user.domain.UserDto;
import lombok.*;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TaskDto {

    @NotNull
    private SprintDto sprint;

    @NotNull
    private String topic;

    private List<UserDto> users;

    private List<ToDoListDto> toDoList;

    private String description;

    @NotNull
    private DateTime creationTime;

    private DateTime doneTime;

    private DateTime modificationTime;

    @NotNull
    private Integer weight;

    private boolean isDone;
}
