package com.pl.ptaq.project_manager.team;

import com.pl.ptaq.project_manager.project.domain.ProjectEntity;
import com.pl.ptaq.project_manager.sprint.SprintEntity;
import com.pl.ptaq.project_manager.user.domain.UserEntity;
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
@Table(name = "teams")
@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID Id;

    private String name;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private UserEntity member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProjectEntity project;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<SprintEntity> sprints;
}
