package com.bfs.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserNavController {

    @GetMapping("/home")
    public String getHomePage() {
        return "user_home";
    }

    @GetMapping( "/profile")
    public String getProfilePage() {
        return "user_profile";
    }


}
