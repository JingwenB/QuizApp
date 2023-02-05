package com.bfs.quizApp.controller.admin;

import com.bfs.quizApp.domain.User;
import com.bfs.quizApp.service.FeedbackService;
import com.bfs.quizApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin_users")
    public String getUsers(
            Model model,
            HttpSession session
    ) {
        //TODO fetch all users:
        // - display all users
        // - update user -> active/ inactive
        // - maybe a detail with quiz history (logically repeated with quizzes)
        List<User> users = userService.getAllUsers(false);
        model.addAttribute("users", users);
        session.setAttribute("users", users);

        return "admin/users";
    }


}
