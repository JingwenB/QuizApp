package com.bfs.quizApp.controller.admin;

import com.bfs.quizApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizzesController {

    @Autowired
    public QuizzesController(

    ) {

    }
    //TODO: fetch all quizzes
    // - display all quizzes -> with filter by category & user_id
    // - each quiz can go into detail

    @GetMapping("/admin_quizzes")
    public String getFeedback(
    ) {

        return "admin/quizzes";
    }



}
