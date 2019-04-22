package com.pl.ptaq.project_manager.user.domain;

class UserMapper {

    public static User map(UserEntity entity) {
        return new User().builder()
                .login(entity.getLogin())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .nick(entity.getNick())
                .build();
    }

    public static UserEntity map(User user) {
        return new UserEntity().builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .nick(user.getNick())
                .build();
    }
}
