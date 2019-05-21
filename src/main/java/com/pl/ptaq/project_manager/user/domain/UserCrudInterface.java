package com.pl.ptaq.project_manager.user.domain;

import java.util.List;

public interface UserCrudInterface {

    boolean addUser(String login, String password, String email, String nick);

    UserDto findUser(String login);

    boolean isUserExist(String login);

    boolean updateUser(String login, String password, String email, String nick);

    boolean deleteUser(String login);

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
