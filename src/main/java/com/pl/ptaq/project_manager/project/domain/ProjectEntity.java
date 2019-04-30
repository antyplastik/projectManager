package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.user.domain.UserEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
@Table(name = "Projects")
@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID projectId;

    @NotNull
    private String projectCode;

    @NotNull
    private String projectName;

    @NotNull
    private String teamId;

    @NotNull
    private String projectDescription;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity adminLogin;

}
