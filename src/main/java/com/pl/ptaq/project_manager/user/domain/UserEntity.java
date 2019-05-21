package com.pl.ptaq.project_manager.user.domain;

import com.pl.ptaq.project_manager.project.domain.ProjectEntity;
import com.pl.ptaq.project_manager.team.TeamEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID Id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @Email
    private String email;

    @NotNull
    private String nickname;

    private UserType userType;

    @OneToMany(mappedBy = "projectManager", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ProjectEntity> projectManager;

    @ManyToMany(mappedBy = "members",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ProjectEntity> projects;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<TeamEntity> teams;
}
