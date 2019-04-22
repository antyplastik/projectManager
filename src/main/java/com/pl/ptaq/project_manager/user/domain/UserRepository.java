package com.pl.ptaq.project_manager.user.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

interface UserRepository extends PagingAndSortingRepository<UserEntity, UUID> {

    UserEntity findByLogin(String login);

}
