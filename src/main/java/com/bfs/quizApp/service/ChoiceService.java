package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.ChoiceDao;
import com.bfs.quizApp.domain.Choice;
import com.bfs.quizApp.domain.Question;
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


    public void createChoicesWithQuestionID(List<String> choice_descriptions, Integer correct_answer_index, int question_id) {
        for (int i = 0; i < choice_descriptions.size(); i++) {
            String description = choice_descriptions.get(i);
            Choice choice = new Choice();
            choice.setQuestion_id(question_id);
            choice.setDescription(description);
            choice.setCorrect(correct_answer_index == i);
            choiceDao.createChoicesWithQuestionID(choice);
        }
    }

    public void updateChoicesWithQuestion(Question oldQuestion, List<String> choice_descriptions, Integer correct_answer_index) {

        for (int i = 0; i < choice_descriptions.size(); i++) {
            String description = choice_descriptions.get(i);
            Choice choice = oldQuestion.getChoices().get(i);
            choice.setDescription(description);
            choice.setCorrect(correct_answer_index == i);
            choiceDao.updateChoice(choice);
        }

    }
}
