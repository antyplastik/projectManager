package com.pl.ptaq.project_manager.user.domain;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoDeleteUser {

    private final UserRepository userRepository;
    private final DtoReadUser dtoReadUser;

    @Autowired
    public DtoDeleteUser(UserRepository userRepository, DtoReadUser dtoReadUser) {
        this.userRepository = userRepository;
        this.dtoReadUser = dtoReadUser;
    }

    public boolean deleteUser(String login) {
        UserEntity found = dtoReadUser.findUserEntity(login);
        if(found != null)
            userRepository.delete(found);

        return dtoReadUser.isUserExist(login) != true;
    }

}
