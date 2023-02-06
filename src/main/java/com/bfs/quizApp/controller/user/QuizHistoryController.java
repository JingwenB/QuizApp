package com.bfs.quizApp.controller.user;

import com.bfs.quizApp.domain.*;
import com.bfs.quizApp.service.ChoiceService;
import com.bfs.quizApp.service.QuestionService;
import com.bfs.quizApp.service.QuizQuestionService;
import com.bfs.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class QuizHistoryController {

    private QuestionService questionService;
    private QuizService quizService;
    private QuizQuestionService qqService;
    private ChoiceService choiceService;
    private HttpSession session;

    @Autowired
    public QuizHistoryController(
            QuestionService questionService,
                          QuizService quizService,
                          QuizQuestionService qqService) {
        this.questionService = questionService;
        this.quizService = quizService;
        this.qqService = qqService;
    }

    @GetMapping( "/user_history")
    public String getHistoryPage(Model model,
                                 HttpSession session) {

        User u = (User) session.getAttribute("user");
        List<Quiz> quizzes = quizService.getQuizzesByUserID(u.getId());
        quizzes.stream().forEach(this::modifyQuiz);
        model.addAttribute("quizzes", quizzes);

        return "user/history";
    }

    @GetMapping( "/details")
    public String getDetailPage(Model model,
                                 @RequestParam("quiz_id") Integer quiz_id
                                ) {
        Quiz quiz = quizService.getQuizzesByQuizID(quiz_id);
        modifyQuiz(quiz);
        model.addAttribute("quiz", quiz);
        model.addAttribute("qqs", quiz.getQuizQuestions());

        return "user/details";
    }

    private void modifyQuiz(Quiz quiz){
        List<QuizQuestion> qqs = qqService.getQuizQuestionsByQuizID(quiz.getId());
        qqs.stream().forEach((qq)->{
            qq.setQuestion(questionService.getQuestionByQuestionId(qq.getQuestion_id()));
        });
        quiz.setQuizQuestions(qqs);
        quiz.setGrade();
//        System.out.println("modified quiz:" + quiz );
    }
}
