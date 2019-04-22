package com.pl.ptaq.project_manager.user.domain;

import com.pl.ptaq.project_manager.user.domain.User;

public interface UserFacadeInterface {

    boolean addUser(String login, String password, String email, String nick);

    User findUser(String login);

    boolean isUserExist(String login);

    boolean updateUser(String login, String password, String email, String nick);

    boolean deleteUser(String login);

}
