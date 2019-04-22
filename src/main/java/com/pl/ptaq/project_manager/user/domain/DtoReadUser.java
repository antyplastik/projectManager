package com.pl.ptaq.project_manager.user.domain;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoReadUser {

    private  final UserRepository userRepository;

    @Autowired
    public DtoReadUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findUserEntity(String login) {
        return userRepository.findByLogin(login);
    }

    public User findUser(String login) {
        return UserMapper.map(findUserEntity(login));
    }

    public boolean isUserExist(String login) {
        return findUser(login) != null;
    }
}
