package com.bfs.quizApp.controller.admin;

import com.bfs.quizApp.domain.Quiz;
import com.bfs.quizApp.domain.QuizQuestion;
import com.bfs.quizApp.domain.User;
import com.bfs.quizApp.service.*;
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
    private final QuizService quizService;

    private final QuestionService questionService;
    private final QuizQuestionService qqService;


    @Autowired
    public UsersController(UserService userService,
                           QuizService quizService,
                           QuestionService questionService,
                           QuizQuestionService qqService) {
        this.userService = userService;

        this.questionService = questionService;
        this.quizService = quizService;
        this.qqService = qqService;

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

    //  activate/deactivate a user
    @PostMapping("/user_status")
    public String changeUserActiveStatus(
            @RequestParam String user_id,
            @RequestParam boolean is_active
    ) {
        userService.changeActiveStatus(user_id, is_active);

        return "redirect:/admin_users";
    }



    //render user detail page, by user_id from HttpSession session
    @GetMapping("/user_details")
    public String getUserDetails(
            @RequestParam Integer user_id,
            Model model
    ) {
        User user = userService.getUserById(user_id);
        List<Quiz> quizzes = quizService.getQuizzesByUserID(user_id);

        quizzes.stream().forEach(this::modifyQuiz);
        model.addAttribute("user", user);
        model.addAttribute("quizzes", quizzes);
        return "admin/user_details";
    }

    // duplicated code(sam with quiz history controller) to setup grade for each quiz
    private void modifyQuiz(Quiz quiz){
        List<QuizQuestion> qqs = qqService.getQuizQuestionsByQuizID(quiz.getId());
        qqs.stream().forEach((qq)->{
            qq.setQuestion(questionService.getQuestionByQuestionId(qq.getQuestion_id()));
        });
        quiz.setQuizQuestions(qqs);
        quiz.setGrade();
    }


}
