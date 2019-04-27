package com.pl.ptaq.project_manager.user.domain;

public interface UserCrudFacade {

    boolean addUser(String login, String password, String email, String nick);

    UserDto findUser(String login);

    boolean isUserExist(String login);

    boolean updateUser(String login, String password, String email, String nick);

    boolean deleteUser(String login);

}
