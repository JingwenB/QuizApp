package com.bfs.quizApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserNavController {

    @GetMapping("/user_home")
    public String getHomePage() {
        System.out.println("getting home");
        return "user/home";
    }

    @GetMapping( "/user_profile")
    public String getProfilePage() {
        return "user/profile";
    }




}
