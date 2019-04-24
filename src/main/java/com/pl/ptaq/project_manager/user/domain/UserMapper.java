package com.pl.ptaq.project_manager.user.domain;

class UserMapper {

    public static UserDto map(UserEntity entity) {
        if (entity != null)
        return new UserDto().builder()
                .login(entity.getLogin())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .nick(entity.getNick())
                .build();
        else
            return null;
    }

    public static UserEntity map(UserDto userDto) {
        if (userDto != null)
        return new UserEntity().builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .nick(userDto.getNick())
                .build();
        else
            return null;
    }
}
