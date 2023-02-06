package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.QuestionDao;
import com.bfs.quizApp.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    public List<Question> getQuestionsForQuiz(String category) {
        List<Question> ret = new ArrayList<>();
        if(category == null || category.equals("")){
            return ret;
        }

        List<Question> questions = getQuestionsWithFilter(category, "true");

        Random r = new Random();
        int[] fiveRandomNumbers = r.ints(5, 0, questions.size()).toArray();
        for(int rint:  fiveRandomNumbers){
            ret.add(questions.get(rint));
        }
        return ret;
    }


    public List<Question> getQuestionsWithFilter(String category, String is_active) {

        List<Question> questions = questionDao.getAllQuestions();

        if(!Objects.equals(category, "") && !Objects.equals(category, "all")){
            questions =
                    questions.stream()
                    .filter((question)->Objects.equals(question.getCategory(), category))
                    .collect(Collectors.toList());
        }

        if(Objects.equals(is_active, "true")) {
            questions =
                    questions.stream()
                    .filter(Question::isActive)
                    .collect(Collectors.toList());
        }

        if(Objects.equals(is_active, "false")) {
            questions =
                    questions.stream()
                            .filter((q)->!q.isActive())
                            .collect(Collectors.toList());
        }

        return questions;
    }


    public Question getQuestionByQuestionId(int question_id) {
        return questionDao.getQuestionByQuestionId(question_id);
    }

    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    public void changeActiveStatus(String question_id, boolean is_active) {
        if(is_active){
            questionDao.deactivateQuestion(question_id);
        } else {
            questionDao.activateQuestion(question_id);
        }
    }
}
