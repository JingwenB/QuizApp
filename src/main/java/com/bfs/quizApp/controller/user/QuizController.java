package com.bfs.quizApp.controller.user;

import com.bfs.quizApp.domain.Question;
import com.bfs.quizApp.domain.Quiz;
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
public class QuizController {

    private QuestionService questionService;
    private QuizService quizService;
    private QuizQuestionService qqService;
    private boolean setQuiz = false;

    @Autowired
    public QuizController(QuestionService questionService,
                          QuizService quizService,
                          QuizQuestionService qqService) {
        this.questionService = questionService;
        this.quizService = quizService;
        this.qqService = qqService;
    }

    @PostMapping("/setCategory")
    public String saveQuizCategory(
            @RequestParam String category,
            HttpSession session) {
        System.out.println("setting category: " + category);
        session.setAttribute("category", category);
        Quiz initQuiz = quizService.createNewQuizInSession(session);
        session.setAttribute("quiz", initQuiz);
//        System.out.println("initQuiz: " + session.getAttribute("quiz"));
        this.setQuiz = true;
        return "redirect:/user_quiz";
    }

    @GetMapping("/user_quiz")
    public String getQuiz(Model model,
                          HttpSession session) {

        Quiz currQuiz = (Quiz) session.getAttribute("quiz");
        if (currQuiz != null && this.setQuiz){
            List<Question> questions = questionService.getQuestionsForQuiz((String) session.getAttribute("category"));

            qqService.createQuizQuestions(currQuiz, questions);
            session.setAttribute("quiz", currQuiz);
            session.setAttribute("questions", questions);
//            System.out.println("Added qq Quiz: " + session.getAttribute("quiz"));
            this.setQuiz = false;
        }
        model.addAttribute("questions", session.getAttribute("questions"));
        return "user/quiz";
    }

    @PostMapping("/submitAnswer")
    public String submitAnswer(
            @RequestParam("questionId") Integer questionId,
            @RequestParam(name = "selectedChoiceId") Integer selectedChoiceId,
            HttpSession session
    ) {
        System.out.println("questionId: " + questionId +
                " selectedChoiceId: " + selectedChoiceId
        );
        Quiz newQuiz = quizService.updateSelection((Quiz) session.getAttribute("quiz"),
                questionId, selectedChoiceId);
        session.setAttribute("quiz", newQuiz);
//        System.out.println("Selected Quiz: " + session.getAttribute("quiz"));

        return "redirect:/user_quiz";
    }

    @PostMapping("/submitQuiz")
    public String submitQuiz(
            HttpSession session
    ) {
        System.out.println("submitting Quiz: \n" +
                "" + session.getAttribute("quiz"));
        quizService.submitQuiz((Quiz)session.getAttribute("quiz"));
        qqService.createQuizQuestions(((Quiz) session.getAttribute("quiz")).getQuizQuestions());
        System.out.println("submitted Quiz");
        return "redirect:/user_history";
    }


}
