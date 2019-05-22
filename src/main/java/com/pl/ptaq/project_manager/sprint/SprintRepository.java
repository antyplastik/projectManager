package com.pl.ptaq.project_manager.sprint;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SprintRepository extends PagingAndSortingRepository<SprintEntity, UUID> {
}
