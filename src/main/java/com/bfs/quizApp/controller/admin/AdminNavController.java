package com.bfs.quizApp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminNavController {

    @GetMapping("/admin_home")
    public String getHomePage() {
        System.out.println("getting admin home");
        return "admin/home";
    }

}
