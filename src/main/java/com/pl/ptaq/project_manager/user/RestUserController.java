package com.pl.ptaq.project_manager.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RestUserController {

//    @Autowired
//    private UserService userService;

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("atrybut","1234");

        return "user";
    }

    @GetMapping("/user/details/{user}")
    public String userDetails(@RequestParam String user){

        return null;
    }
}
