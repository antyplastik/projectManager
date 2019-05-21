package com.pl.ptaq.project_manager.sprint;

import com.pl.ptaq.project_manager.project.domain.ProjectEntity;
import com.pl.ptaq.project_manager.task.domain.TaskEntity;
import com.pl.ptaq.project_manager.team.TeamEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "sprints")
@Entity
public class SprintEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID Id;

    private String sprintName;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startDate;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime stopDate;

    private Double burn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team")
    private TeamEntity team;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProjectEntity project;

    @OneToMany (mappedBy = "sprint", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<TaskEntity> tasks;
}
