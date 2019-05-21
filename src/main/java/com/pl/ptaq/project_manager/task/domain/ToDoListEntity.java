package com.pl.ptaq.project_manager.task.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "toDoListRows")
@Entity
class ToDoListEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID toDoListRowId;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaskEntity task;

    private String rowDescription;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isDone;
}
