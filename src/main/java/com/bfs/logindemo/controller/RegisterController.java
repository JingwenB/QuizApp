package com.bfs.logindemo.controller;

import com.bfs.logindemo.domain.User;
import com.bfs.logindemo.service.LoginService;
import com.bfs.logindemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(HttpSession session, Model model) {

        if (session != null && session.getAttribute("user") != null) {
            return "redirect:/home";
        }

        System.out.println("in register");
        return "register";
    }

    @PostMapping("/create_user")
    public String PostRegister(HttpSession session, Model model) {

        System.out.println("in register submit button");
        return "redirect:/register";
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
