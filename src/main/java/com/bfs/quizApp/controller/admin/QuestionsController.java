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
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionsController {

    //Fetch all questions:
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
            Model model
    ) {

        List<Question> questions = questionService.getQuestionsWithFilter(category, is_active);
        model.addAttribute("questions", questions);
        return "admin/questions";
    }

    @GetMapping("/create_question")
    public String getCreateQuestionPage(
    ) {
        return "admin/create_question";
    }

    @PostMapping("/create_question")
    public String createQuestion(
            @RequestParam String category,
            @RequestParam String description,
            @RequestParam String choice_1,
            @RequestParam String choice_2,
            @RequestParam String choice_3,
            @RequestParam String choice_4,

            @RequestParam Integer correct_answer_index

    ) {
        List<String> choice_descriptions = new ArrayList<>();
        choice_descriptions.add(choice_1);
        choice_descriptions.add(choice_2);
        choice_descriptions.add(choice_3);
        choice_descriptions.add(choice_4);
        questionService.createNewQuestionWithChoices(category, description,
                choice_descriptions, correct_answer_index);
        return "redirect:/admin_questions";
    }

    @GetMapping("/modify_question")
    public String getModifyQuestionPage(
            @RequestParam Integer question_id,
            HttpSession session,
            Model model
    ) {
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Question question = questions.stream().filter((q)->q.getId()==question_id).findFirst().orElse(null);
        if(question == null){
            return "redirect:/admin_questions";
        }
        model.addAttribute("question", question);
        session.setAttribute("question_to_modify", question);
        return "admin/modify_question";
    }

    @PostMapping("/modify_question")
    public String modifyQuestion(
            @RequestParam String description,
            @RequestParam String choice_1,
            @RequestParam String choice_2,
            @RequestParam String choice_3,
            @RequestParam String choice_4,

            @RequestParam Integer correct_answer_index,
            HttpSession session
    ) {
        Question oldQuestion = (Question) session.getAttribute("question_to_modify");
        List<String> choice_descriptions = new ArrayList<>();
        choice_descriptions.add(choice_1);
        choice_descriptions.add(choice_2);
        choice_descriptions.add(choice_3);
        choice_descriptions.add(choice_4);

        questionService.modifyQuestion(oldQuestion, description, choice_descriptions, correct_answer_index);
        return "redirect:/admin_questions";
    }




}
