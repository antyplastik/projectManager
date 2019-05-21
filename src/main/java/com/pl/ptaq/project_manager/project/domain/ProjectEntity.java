package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.sprint.SprintEntity;
import com.pl.ptaq.project_manager.task.domain.TaskEntity;
import com.pl.ptaq.project_manager.team.TeamEntity;
import com.pl.ptaq.project_manager.user.domain.UserEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "projects")
@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID Id;

    @NotNull
    private String projectCode;

    @NotNull
    private String projectName;

    @ManyToOne
    private TeamEntity team;

    @NotNull
    private String projectDescription;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<SprintEntity> sprints;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity projectManager;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<UserEntity> members;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<TeamEntity> teams;

//    private List<TaskEntity> tasks;

    private boolean isActive;
}
