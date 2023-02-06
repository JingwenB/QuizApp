package com.bfs.quizApp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbacksController {


    @Autowired
    public FeedbacksController() {

    }

    @GetMapping("/admin_feedbacks")
    public String getFeedback(
    ) {
        // TODO: fetch all feedbacks and display

        return "admin/feedbacks";
    }



}
