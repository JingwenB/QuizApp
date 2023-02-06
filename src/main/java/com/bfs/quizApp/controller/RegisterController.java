package com.bfs.quizApp.controller;

import com.bfs.quizApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(HttpSession session, Model model) {

        if (session != null && session.getAttribute("user") != null) {
            return "redirect:/user_home";
        }

        System.out.println("in register");
        return "register";
    }

    @PostMapping ("/register")
    public String registerNewUser(@RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName,
                                  HttpSession session) {
        userService.createNewUser(email,password,firstName,lastName);

        System.out.println("in register");
        return "redirect:/login";
    }
}
