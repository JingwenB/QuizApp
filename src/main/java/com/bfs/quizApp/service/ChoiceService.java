package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.ChoiceDao;
import com.bfs.quizApp.domain.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {
    private final ChoiceDao choiceDao;

    @Autowired
    public ChoiceService(ChoiceDao choiceDao) {
        this.choiceDao = choiceDao;
    }


    public Choice getChoiceByChoiceID(int choice_id) {
        return choiceDao.getChoiceByChoiceID(choice_id);
    }

    public List<Choice> getChoicesByQuestionID(int question_id) {
        return choiceDao.getChoicesByQuestionID(question_id);
    }


}
