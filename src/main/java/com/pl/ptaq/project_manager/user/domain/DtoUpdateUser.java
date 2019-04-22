package com.pl.ptaq.project_manager.user.domain;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoUpdateUser {

    private final UserRepository userRepository;
    private final DtoReadUser dtoReadUser;

    @Autowired
    public DtoUpdateUser(UserRepository userRepository, DtoReadUser dtoReadUser) {
        this.userRepository = userRepository;
        this.dtoReadUser = dtoReadUser;
    }

    public boolean updateUser(String login, String password, String email, String nick) {
        UserEntity found = dtoReadUser.findUserEntity(login);
        UserEntity modified = found;
        if (found != null) {
            modified.setPassword(password);
            modified.setEmail(email);
            modified.setNick(nick);

            userRepository.save(modified);
            return modified.hashCode() != found.hashCode();
        }
        return false;
    }
}
