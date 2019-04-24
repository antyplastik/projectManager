package com.pl.ptaq.project_manager.project.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
class ProjectEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID projectId;

    @NotNull
    private String projectName;

    @NotNull
    private String teamId;

    @NotNull
    private String projectDescription;

    @NotNull
    private String adminLogin;

}
