package com.pl.ptaq.project_manager.user.domain;

import org.junit.Before;
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

    private UserCrudInterface userService;
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
                .nickname(nick)
                .build();
    }

    @Test
    public void WHEN_add_new_user_and_after_add_user_exist_THEN_true() {
        assertTrue(userService.createUser(userDto)
        );
    }

    @Test
    public void WHEN_add_new_user_that_already_exist_THEN_false() {
        userRepository.save(UserMapper.map(userDto));
        assertFalse(userService.createUser(userDto));
    }

    @Test
    public void WHEN_found_exist_user_THEN_return_user() {
        userRepository.save(UserMapper.map(userDto));
        assertNotNull(userService.readUser(userDto));
    }

    @Test
    public void WHEN_user_exist_THEN_return_true() {
        userRepository.save(UserMapper.map(userDto));
        assertTrue(userService.isUserExist(userDto));
    }

    @Test
    public void WHEN_update_user_found_and_modified_entities_are_not_the_same_THEN_true() {
        userRepository.save(UserMapper.map(userDto));

        UserDto modified = new UserDto().builder()
                .login("modified")
                .password("321mod123")
                .email("modified@mod.com")
                .nickname("mod")
                .userType(UserType.SCRUM_MASTER)
                .build();

        assertTrue(userService.updateUser(modified, userDto));

    }

    @Test
    public void WHEN_delete_exist_user_THEN_true() {
        userRepository.save(UserMapper.map(userDto));
        assertTrue(userService.deleteUser(userDto));
    }

    @Test
    public void WHEN_delete_user_that_not_exist_THEN_false() {
        assertFalse(userService.deleteUser(userDto));
    }
}