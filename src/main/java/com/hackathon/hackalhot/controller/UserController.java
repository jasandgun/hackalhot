package com.hackathon.hackalhot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(path = "/user-profile")
    public String userProfile() {
        return "user/profile";
    }

    @GetMapping(path = "/user-login")
    public String userLogin() {
        return "user/login";
    }

    @GetMapping(path = "/user-register")
    public String userRegister() {
        return "user/register";
    }
}
