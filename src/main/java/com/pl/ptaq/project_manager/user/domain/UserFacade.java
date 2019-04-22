package com.pl.ptaq.project_manager.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacade implements UserFacadeInterface {

    private final DtoCreateUser createUser;

    private final  DtoReadUser readUser;

    private final  DtoUpdateUser updateUser;

    private final DtoDeleteUser deleteUser;

    @Autowired
    public UserFacade(DtoCreateUser createUser, DtoReadUser readUser, DtoUpdateUser updateUser, DtoDeleteUser deleteUser) {
        this.createUser = createUser;
        this.readUser = readUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @Override
    public boolean addUser(String login, String password, String email, String nick) {
        return createUser.addUser(login, password, email, nick);
    }

    @Override
    public User findUser(String login) {
        return readUser.findUser(login);
    }

    @Override
    public boolean isUserExist(String login) {
        return readUser.isUserExist(login);
    }

    @Override
    public boolean updateUser(String login, String password, String email, String nick) {
        return updateUser.updateUser(login, password, email, nick);
    }

    @Override
    public boolean deleteUser(String login) {
        return deleteUser.deleteUser(login);
    }
}
