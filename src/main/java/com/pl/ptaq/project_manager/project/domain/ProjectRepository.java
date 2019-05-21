package com.pl.ptaq.project_manager.project.domain;

import com.pl.ptaq.project_manager.team.TeamEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface ProjectRepository extends PagingAndSortingRepository<ProjectEntity, UUID> {

    ProjectEntity findByProjectCode(UUID uuid);

    ProjectEntity findByProjectCode (String projectCode);

    ProjectEntity findByProjectName (String projectName);

    List<ProjectEntity> findAllByTeam(TeamEntity teamId);

    List<ProjectEntity> findAllByProjectManager(String adminId);

    List<ProjectEntity> findAllByProjectNameLike(String projectName);

    List<ProjectEntity> findAllByProjectDescriptionLike(String description);

}
