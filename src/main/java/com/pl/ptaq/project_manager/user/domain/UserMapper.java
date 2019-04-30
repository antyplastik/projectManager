package com.pl.ptaq.project_manager.user.domain;

class UserMapper {

    public static UserDto map(UserEntity entity) {
        if (entity != null)
        return new UserDto().builder()
                .login(entity.getUserLogin())
                .password(entity.getUserPassword())
                .email(entity.getUserEmail())
                .nick(entity.getUserNick())
                .build();
        else
            return null;
    }

    public static UserEntity map(UserDto userDto) {
        if (userDto != null)
        return new UserEntity().builder()
                .userLogin(userDto.getLogin())
                .userPassword(userDto.getPassword())
                .userEmail(userDto.getEmail())
                .userNick(userDto.getNick())
                .build();
        else
            return null;
    }
}
