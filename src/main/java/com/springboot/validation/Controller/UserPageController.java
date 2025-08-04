package com.springboot.validation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {


    @GetMapping("/display")
    public String displayPage() {
        return "display";  // display.html in src/main/resources/templates/
    }

    @GetMapping("/register")
    public String registerPage() {
        return "registration";  // registration.html
    }
    @GetMapping("/allusers")
    public String showAllUsersPage() {
        return "allusers"; // corresponds to allusers.html in templates folder
    }
}


