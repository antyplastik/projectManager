package com.pl.ptaq.project_manager.task.domain;

import com.pl.ptaq.project_manager.user.domain.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, UUID> {
    Optional<TaskEntity> findAllByUsers(UserEntity userEntity);
}
