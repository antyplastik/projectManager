package com.pl.ptaq.project_manager.task.domain;
import lombok.*;
import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
class ToDoListDto {

    private String rowDescription;
    private boolean isDone;
    private DateTime modificationTime;
}
