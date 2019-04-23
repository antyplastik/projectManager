package com.pl.ptaq.project_manager.user.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class UserService implements UserFacadeInterface {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    public UserService(UserRepository repository) {
//        userRepository = repository;
//    }

    @Override
    public boolean addUser(String login, String password, String email, String nick) {
        if (!isUserExist(login)) {
            UserEntity user = new UserEntity().builder()
                    .login(login)
                    .password(password)
                    .email(email)
                    .nick(nick)
                    .build();
            userRepository.save(user);
            return true;
        } else
            return false;
    }

    public UserEntity findUserEntity(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findUser(String login) {
        return UserMapper.map(findUserEntity(login));
    }

    @Override
    public boolean isUserExist(String login) {
        return findUser(login) != null;
    }

    @Override
    public boolean updateUser(String login, String password, String email, String nick) {
        UserEntity found = findUserEntity(login);
        UserEntity modified = found;
        if (found != null) {
            modified.setPassword(password);
            modified.setEmail(email);
            modified.setNick(nick);

            userRepository.save(modified);
            return modified.hashCode() != found.hashCode();
        }
        return false;
    }

    @Override
    public boolean deleteUser(String login) {
        return false;
    }
}
