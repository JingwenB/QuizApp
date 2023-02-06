package com.bfs.quizApp.controller.admin;

import com.bfs.quizApp.domain.Quiz;
import com.bfs.quizApp.domain.QuizQuestion;
import com.bfs.quizApp.service.QuestionService;
import com.bfs.quizApp.service.QuizQuestionService;
import com.bfs.quizApp.service.QuizService;
import com.bfs.quizApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QuizzesController {
    private final QuestionService questionService;
    private final QuizService quizService;
    private final QuizQuestionService qqService;

    @Autowired
    public QuizzesController(
            QuestionService questionService,
            QuizService quizService,
            QuizQuestionService qqService
    ) {
        this.questionService = questionService;
        this.quizService = quizService;
        this.qqService = qqService;
    }
    //TODO: fetch all quizzes
    // - display all quizzes -> with filter by category & user_id
    // - each quiz can go into detail

    @GetMapping("/admin_quizzes")
    public String getQuizzes(Model model,
                             HttpSession session) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        quizzes.stream().forEach(this::modifyQuiz);
        model.addAttribute("quizzes", quizzes);
        session.setAttribute("quizzes", quizzes);
        return "admin/quizzes";
    }


    @GetMapping("/getQuizzesWithFilter")
    public String getQuizzesWithFilter(
            @RequestParam String category,
            @RequestParam String user_id,
            Model model,
            HttpSession session) {
        List<Quiz> quizzes = quizService.getQuizzesWithFilter(category, user_id);
        quizzes.stream().forEach(this::modifyQuiz);
        model.addAttribute("quizzes", quizzes);
        session.setAttribute("quizzes", quizzes);
        return "admin/quizzes";
    }

    @GetMapping( "/admin_quiz_details")
    public String getDetailPage(Model model,
                                @RequestParam("quiz_id") Integer quiz_id
    ) {
        Quiz quiz = quizService.getQuizzesByQuizID(quiz_id);
        modifyQuiz(quiz);
        model.addAttribute("quiz", quiz);
        model.addAttribute("qqs", quiz.getQuizQuestions());

        return "admin/details";
    }

    private void modifyQuiz(Quiz quiz){
        List<QuizQuestion> qqs = qqService.getQuizQuestionsByQuizID(quiz.getId());
        qqs.stream().forEach((qq)->{
            qq.setQuestion(questionService.getQuestionByQuestionId(qq.getQuestion_id()));
        });
        quizService.setUserToQuiz(quiz);
        quiz.setQuizQuestions(qqs);
        quiz.setGrade();
    }

}
