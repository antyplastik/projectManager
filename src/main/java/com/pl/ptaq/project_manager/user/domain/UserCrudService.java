package com.pl.ptaq.project_manager.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserCrudService implements UserCrudInterface {

    private final UserRepository repository;

    @Autowired
    public UserCrudService(UserRepository repository) {
        this.repository = repository;
    }

    private UserEntity createNewUserEntity(UserDto user) {
        return new UserEntity().builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();
    }

    @Override
    public boolean createUser(UserDto user) {
        UserEntity userEntity;
        if (!isUserExist(user)) {
            userEntity = createNewUserEntity(user);

            return repository.save(userEntity) != null;
        }
        return false;
    }

    private UserEntity findUserEntity(UserDto user) {
        Optional<UserEntity> found = repository.findByLogin(user.getLogin());
        return found.isPresent() ? found.get() : null;
    }

    @Override
    public UserDto readUser(UserDto user) {
        return UserMapper.map(findUserEntity(user));
    }

    @Override
    public boolean isUserExist(UserDto user) {
        return readUser(user) != null;
    }

    @Override
    public boolean updateUser(UserDto newUser, UserDto oldUser) {
        UserEntity found = findUserEntity(oldUser);
        if (found != null) {

            String[] updates = {
                    newUser.getLogin(),
                    newUser.getPassword(),
                    newUser.getEmail(),
                    newUser.getNickname(),
            };

            if (updates[0] != null)
                found.setLogin(updates[0]);
            if(updates[1] != null)
                found.setPassword(updates[1]);
            if(updates[2] != null)
                found.setEmail(updates[2]);
            if(updates[3] != null)
                found.setNickname(updates[3]);

            if(newUser.getUserType() != null)
                found.setUserType(newUser.getUserType());

                if (updates != null) {
                    repository.save(found);
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean deleteUser(UserDto user) {
        UserEntity found = findUserEntity(user);
        if (found != null) {
            repository.delete(found);
            return true;
        }
        return false;
    }

    public static UserDto map(UserEntity entity) {
        return UserMapper.map(entity);
    }

    public static UserEntity map(UserDto dto) {
        return UserMapper.map(dto);
    }

    static List<UserDto> mapDtoList(List<UserEntity> entities) {
        return entities.stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }

    static List<UserEntity> mapEntityList(List<UserDto> dtos) {
        return dtos.stream()
                .map(dto -> map(dto))
                .collect(Collectors.toList());
    }
}
