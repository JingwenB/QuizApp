package com.bfs.quizApp.controller.admin;

import com.bfs.quizApp.domain.Feedback;
import com.bfs.quizApp.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FeedbacksController {
    private final FeedbackService feedbackService;
    //TODO: Fetch all Feedbacks:
    // - display all Feedbacks
    // - display an overall rate

    @Autowired
    public FeedbacksController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/admin_feedbacks")
    public String getFeedback(
            Model model,
            HttpSession session
    ) {
        List<Feedback> fbs = feedbackService.getAllFeedbacks();
        fbs.stream().forEach(feedbackService::setUser);

        double rate = fbs.stream().mapToInt((fb)->fb.getRating()).average().getAsDouble();
        model.addAttribute("feedbacks", fbs);
        model.addAttribute("overall_rate", rate);
        return "admin/feedbacks";
    }





}
