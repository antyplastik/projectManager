package com.pl.ptaq.project_manager.user.domain;

import java.util.List;

public interface UserCrudInterface {

    boolean createUser(UserDto user);

    UserDto readUser(UserDto user);

    boolean isUserExist(UserDto user);

    boolean updateUser(UserDto newUser, UserDto oldUser);

    boolean deleteUser(UserDto user);

    static UserDto map (UserEntity entity){
        return UserMapper.map(entity);
    }

    static UserEntity map(UserDto dto) {
        return UserMapper.map(dto);
    }

    static List<UserDto> mapDtoList(List<UserEntity> entities){
        return UserMapper.MapDtoList(entities);
    }

    static List<UserEntity> mapEntityList(List<UserDto> dtos){
        return UserMapper.MapEntityList(dtos);
    }
}
