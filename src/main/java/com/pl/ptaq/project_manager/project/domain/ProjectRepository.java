package com.pl.ptaq.project_manager.project.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface ProjectRepository extends PagingAndSortingRepository<ProjectEntity, UUID> {

    ProjectEntity findByPAndProjectId (UUID uuid);

    ProjectEntity findByProjectName (String projectName);

    List<ProjectEntity> findAllByTeamId (String teamId);

    List<ProjectEntity> findAllByAdminLogin (String adminId);

    List<ProjectEntity> findAllByProjectDescriptionLike(String description);

}
