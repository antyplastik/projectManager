package com.pl.ptaq.project_manager.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService implements UserCrudFacade {

    private final UserRepository repository;

    @Autowired
    public UserCrudService(UserRepository repository) {
        this.repository = repository;
    }

    private UserEntity createOrModifyUserEntity(String login, String password, String email, String nick) {
        return new UserEntity().builder()
                .userLogin(login)
                .userPassword(password)
                .userEmail(email)
                .userNick(nick)
                .build();
    }

    @Override
    public boolean addUser(String login, String password, String email, String nick) {
        UserEntity user;
        if (!isUserExist(login)) {
            user = createOrModifyUserEntity(login, password, email, nick);

            repository.save(user);

            return isUserExist(user.getUserLogin());
        }
        return false;
    }

    private UserEntity findUserEntity(String login) {
        return repository.findByUserLogin(login);
    }

    @Override
    public UserDto findUser(String login) {
        return UserMapper.map(findUserEntity(login));
    }

    @Override
    public boolean isUserExist(String login) {
        return findUser(login) != null;
    }

    @Override
    public boolean updateUser(String login, String password, String email, String nick) {
        UserEntity found = findUserEntity(login);
        if (found != null) {
            UserEntity modified = createOrModifyUserEntity(
                    found.getUserLogin(),
                    found.getUserPassword(),
                    found.getUserEmail(),
                    found.getUserNick()
            );

            if (modified.hashCode() != found.hashCode()){
                repository.save(modified);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(String login) {
        UserEntity found = findUserEntity(login);
        if (found != null) {
            repository.delete(found);
            return !isUserExist(found.getUserLogin());
        }
        return false;
    }

    public static UserEntity map(UserDto dto) {
        return UserMapper.map(dto);
    }

    public static UserDto map (UserEntity entity){
        return UserMapper.map(entity);
    }
}
