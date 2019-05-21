package com.pl.ptaq.project_manager.user.domain;

import java.util.List;
import java.util.stream.Collectors;

class UserMapper {

    public static UserDto map(UserEntity entity) {
        if (entity != null)
        return new UserDto().builder()
                .login(entity.getLogin())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .nick(entity.getNickname())
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
                .nickname(userDto.getNick())
                .build();
        else
            return null;
    }

    public static List<UserDto> MapDtoList(List<UserEntity> entities){
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    public static List<UserEntity> MapEntityList(List<UserDto> dtos){
        return dtos.stream()
                .map(dto->map(dto))
                .collect(Collectors.toList());
    }
}
