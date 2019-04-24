package com.pl.ptaq.project_manager.user.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserFacadeTest {

    @Autowired
    UserRepository userRepository;

    private UserFacade userService;
    private UserDto userDto;

    @Before
    public void setUp(){
        userService = new UserService(userRepository);

        String login = "testUser";
        String password = "testtest";
        String email = "test@test.com";
        String nick = "testtest";

        String[] testUser = new String[] {login,password,email,nick};
    }

    @Test
    public void when_add_new_user_and_after_this_user_exist_then_true() {
        String login = "testUser";
        String password = "testtest";
        String email = "test@test.com";
        String nick = "testtest";

        String[] testUser = new String[] {login,password,email,nick};

        assertTrue(userService.addUser(testUser[0],testUser[1],testUser[2],testUser[3]));
    }

    @Ignore
    @Test
    public void findUser() {
    }

    @Ignore
    @Test
    public void isUserExist() {
    }

    @Test
    public void when_update_user_compare_with_entity_then_return_true() {
    }

    @Test
    public void deleteUser() {
    }
}