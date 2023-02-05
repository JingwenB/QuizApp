package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.QuestionDao;
import com.bfs.quizApp.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    public List<Question> getQuestionsByCategory(String Category) {
        List<Question> ret = new ArrayList<>();
        if(Category == null){
            return ret;
        }
        List<Question> all_question = questionDao.getQuestionsByCategory(Category);
        Random r = new Random();
        int[] fiveRandomNumbers = r.ints(5, 0, all_question.size()).toArray();
        for(int rint:  fiveRandomNumbers){
            ret.add(all_question.get(rint));
        }
        return ret;
    }


    public Question getQuestionByQuestionId(int question_id) {
        return questionDao.getQuestionByQuestionId(question_id);
    }
}
