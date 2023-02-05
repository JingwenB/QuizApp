package com.bfs.quizApp.controller;

import com.bfs.quizApp.domain.User;
import com.bfs.quizApp.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

//         redirect to /home if user is already logged in
        if (session != null && session.getAttribute("user") != null) {
            if(((User) session.getAttribute("user")).isAdmin()){
                return "redirect:/admin_home";
            } else {
                return "redirect:/user_home";
            }
        }

        return "login";
    }

    // validate that we are always getting a new session after login
    @PostMapping("/login")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request) {

        Optional<User> possibleUser = loginService.validateLogin(username, password);

        if(possibleUser.isPresent()) {
            HttpSession oldSession = request.getSession(false);

            // invalidate old session if it exists
            if (oldSession != null) oldSession.invalidate();

            // generate new session
            HttpSession newSession = request.getSession(true);

            // store user details in session
            newSession.setAttribute("user", possibleUser.get());

            // not active => cannot log in,
            // user => user home, admin => admin home
            if(!possibleUser.get().isActive()){
                return "login";
            }
            System.out.println(possibleUser.get());
            if(!possibleUser.get().isAdmin()){
                System.out.println("not admin getting user home");
                return "redirect:/user_home";
            } else {
                System.out.println("getting admin home");
                return "redirect:/admin_home";
            }

        }
        return "login";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession oldSession = request.getSession(false);
        // invalidate old session if it exists
        if(oldSession != null) oldSession.invalidate();
        return "login";
    }
}
