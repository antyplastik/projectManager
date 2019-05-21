package com.pl.ptaq.project_manager.user.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, UUID> {

    UserEntity findByLogin(String login);

}
