package com.pl.ptaq.project_manager.user.domain;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoCreateUser {

    private final UserRepository userRepository;
    private final DtoReadUser dtoReadUser;

    @Autowired
    public DtoCreateUser(UserRepository userRepository, DtoReadUser dtoReadUser) {
        this.userRepository = userRepository;
        this.dtoReadUser = dtoReadUser;
    }

    public boolean addUser(String login, String password, String email, String nick) {
        if (!dtoReadUser.isUserExist(login)) {
            UserEntity user = new UserEntity().builder()
                    .login(login)
                    .password(password)
                    .email(email)
                    .nick(nick)
                    .build();
            userRepository.save(user);
            return true;
        } else
            return false;
    }
}
