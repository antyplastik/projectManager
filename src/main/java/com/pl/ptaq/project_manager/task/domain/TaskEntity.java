package com.pl.ptaq.project_manager.task.domain;

import com.pl.ptaq.project_manager.project.domain.ProjectEntity;
import com.pl.ptaq.project_manager.sprint.SprintEntity;
import com.pl.ptaq.project_manager.user.domain.UserEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "Tasks")
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    private SprintEntity sprint;

    @ManyToOne
    private ProjectEntity project;

    @NotNull
    private String topic;

    @OneToMany(fetch = FetchType.LAZY)
    private List<UserEntity> users;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<ToDoListEntity> toDoList;

    private String description;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationTime;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime doneTime;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;

    @NotNull
    private Integer weight;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isDone;
}
