package com.pl.ptaq.project_manager.user.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserCrudFacadeTest {

    @Autowired
    UserRepository userRepository;

    private UserCrudFacade userService;
    private UserDto userDto;

    @Before
    public void setUp() {
        userService = new UserCrudService(userRepository);

        String login = "testUser";
        String password = "testtest";
        String email = "test@test.com";
        String nick = "testtest";

        userDto = userDto.builder()
                .login(login)
                .password(password)
                .email(email)
                .nick(nick)
                .build();
    }

    @Test
    public void WHEN_add_new_user_and_user_exist_THEN_true() {
        assertTrue(userService.addUser(
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getNick()
                )
        );
    }

    @Test
    public void WHEN_add_new_user_that_already_exist_THEN_false() {
        userRepository.save(UserMapper.map(userDto));
        assertFalse(userService.addUser(
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getNick()
                )
        );
    }

    @Test
    public void WHEN_find_exist_user_THEN_return_user() {
        userRepository.save(UserMapper.map(userDto));
        assertNotNull(userService.findUser(userDto.getLogin()));
    }

    @Test
    public void WHEN_user_exist_THEN_return_true() {
        userRepository.save(UserMapper.map(userDto));
        assertTrue(userService.isUserExist(userDto.getLogin()));
    }

    @Test
    public void WHEN_update_user_found_and_modified_entities_are_not_the_same_THEN_true() {
        userRepository.save(UserMapper.map(userDto));
        assertTrue(userService.updateUser(userDto.getLogin(),
                "changed",
                "changed@test.com.pl",
                "changedNick"));

    }

    @Test
    public void WHEN_delete_exist_user_THEN_true() {
        userRepository.save(UserMapper.map(userDto));
        assertTrue(userService.deleteUser(userDto.getLogin()));
    }

    @Test
    public void WHEN_delete_user_that_not_exist_THEN_false() {
        assertFalse(userService.deleteUser(userDto.getLogin()));
    }
}