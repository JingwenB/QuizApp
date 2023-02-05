package com.bfs.logindemo.controller;

import com.bfs.logindemo.domain.User;
import com.bfs.logindemo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback")
    public String getFeedback(
    ) {
        return "feedback";
    }




    @PostMapping ("/feedback")
    public String submitFeedback(
            @RequestParam Integer star,
            @RequestParam String message,
            HttpSession session
    ) {
        System.out.println(star+ " " + message);
        feedbackService.createNewFeedback(star, message, (User) session.getAttribute("user") );
        return "redirect:/home";
    }


}
