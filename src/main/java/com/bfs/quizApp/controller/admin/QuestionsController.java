package com.bfs.quizApp.controller.admin;

import com.bfs.quizApp.domain.Question;
import com.bfs.quizApp.service.QuestionService;
import com.bfs.quizApp.service.QuizQuestionService;
import com.bfs.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QuestionsController {

    //TODO fetch all questions:
    // - display all question -> can filter by category
    // - update question -> active/ inactive
    // - create new question (low priority)
    // - update question with answer/ description (low priority)

    private QuestionService questionService;

    @Autowired
    public QuestionsController(
            QuestionService questionService
    ) {
        this.questionService = questionService;
    }

    @GetMapping("/admin_questions")
    public String getQuestions(
            Model model,
            HttpSession session
    ) {
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        session.setAttribute("questions", questions);
        return "admin/questions";
    }

    //  activate/deactivate a question
    @PostMapping("/question_status")
    public String changeQuestionActiveStatus(
            @RequestParam String question_id,
            @RequestParam boolean is_active
    ) {

        questionService.changeActiveStatus(question_id, is_active);
        return "redirect:/admin_questions";
    }

    @GetMapping("/getQuestionsWithFilter")
    public String filterQuestions(
            @RequestParam String category,
            @RequestParam String is_active,
            Model model,
            HttpSession session
    ) {

        List<Question> questions = questionService.getQuestionsWithFilter(category, is_active);
        model.addAttribute("questions", questions);
        session.setAttribute("questions", questions);
        return "admin/questions";
    }


}
