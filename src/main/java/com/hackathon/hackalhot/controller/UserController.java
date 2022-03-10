package com.hackathon.hackalhot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(path = "/terhibah")
    public String deliveredBarang() {
        return "terhibah";
    }
    @GetMapping(path = "/user-profile")
    public String userProfile() {
        return "profile";
    }
    @GetMapping(path = "/user-login")
    public String userLogin() {
        return "login";
    }
    @GetMapping(path = "/user-register")
    public String userRegister() {
        return "register";
    }
}
