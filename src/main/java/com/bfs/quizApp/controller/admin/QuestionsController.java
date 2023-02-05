package com.bfs.quizApp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionsController {

    @Autowired
    public QuestionsController(

    ) {

    }

    @GetMapping("/admin_questions")
    public String getFeedback(
    ) {
        //TODO fetch all questions:
        // - display all question
        // - update question -> active/ inactive
        // - create new question (low priority)
        // - update question with answer/ description (low priority)
        return "admin/questions";
    }



}
