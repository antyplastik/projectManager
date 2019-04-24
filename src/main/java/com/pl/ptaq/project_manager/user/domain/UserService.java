package com.pl.ptaq.project_manager.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserFacade {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(String login, String password, String email, String nick) {
        UserEntity user = null;
        if (!isUserExist(login)) {
            user = new UserEntity().builder()
                    .login(login)
                    .password(password)
                    .email(email)
                    .nick(nick)
                    .build();
            userRepository.save(user);
        }
        return isUserExist(user.getLogin());
    }

    public UserEntity findUserEntity(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDto findUser(String login) {
        return UserMapper.map(findUserEntity(login));
    }

    @Override
    public boolean isUserExist(String login) {
        return findUser(login) != null;
    }

    @Override
    public boolean updateUser(String login, String password, String email, String nick) {
        UserEntity found = findUserEntity(login);
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

    @Override
    public boolean deleteUser(String login) {
        return false;
    }
}
