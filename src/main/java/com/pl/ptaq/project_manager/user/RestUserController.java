package com.pl.ptaq.project_manager.user;

import com.pl.ptaq.project_manager.user.domain.UserCrudInterface;
import com.pl.ptaq.project_manager.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
class RestUserController {

    @Autowired
    private UserCrudInterface userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.FOUND)
    public boolean user(UserDto dto) {
        return userService.createUser(dto);
    }

    @PostMapping("/find")
    public UserDto findUser(@RequestParam String login){

        return userService.readUser(new UserDto().builder()
                .login(login)
                .build());
    }
}
