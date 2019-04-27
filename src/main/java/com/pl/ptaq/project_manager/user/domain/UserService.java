package com.pl.ptaq.project_manager.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserFacade {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addUser(String login, String password, String email, String nick) {
        UserEntity user;
        if (!isUserExist(login)) {
            user = new UserEntity().builder()
                    .login(login)
                    .password(password)
                    .email(email)
                    .nick(nick)
                    .build();

            repository.save(user);

            return isUserExist(user.getLogin());
        }
        return false;
    }

    private UserEntity findUserEntity(String login) {
        return repository.findByLogin(login);
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

            repository.save(modified);
            return modified.hashCode() != found.hashCode();
        }
        return false;
    }

    @Override
    public boolean deleteUser(String login) {
        UserEntity found = findUserEntity(login);
        if (found != null) {
            repository.delete(found);
            return !isUserExist(found.getLogin());
        }
        return false;
    }
}
