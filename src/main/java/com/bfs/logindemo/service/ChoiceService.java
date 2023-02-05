package com.bfs.logindemo.service;

import com.bfs.logindemo.dao.ChoiceDao;
import com.bfs.logindemo.dao.QuestionDao;
import com.bfs.logindemo.domain.Choice;
import com.bfs.logindemo.domain.Question;
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
