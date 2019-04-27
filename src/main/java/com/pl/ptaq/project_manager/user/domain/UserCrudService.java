package com.pl.ptaq.project_manager.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserCrudService implements UserCrudFacade {

    private final UserRepository repository;

    @Autowired
    public UserCrudService(UserRepository repository) {
        this.repository = repository;
    }

    private UserEntity createOrModifyUserEntity(String login, String password, String email, String nick) {
        return new UserEntity().builder()
                .login(login)
                .password(password)
                .email(email)
                .nick(nick)
                .build();
    }

    @Override
    public boolean addUser(String login, String password, String email, String nick) {
        UserEntity user;
        if (!isUserExist(login)) {
            user = createOrModifyUserEntity(login, password, email, nick);

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
        if (found != null) {
            UserEntity modified = createOrModifyUserEntity(
                    found.getLogin(),
                    found.getPassword(),
                    found.getEmail(),
                    found.getNick()
            );

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
