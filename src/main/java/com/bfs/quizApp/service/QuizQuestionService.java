package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.QuizQuestionDao;
import com.bfs.quizApp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizQuestionService {
    private final QuizQuestionDao quizQuestionDao;

    @Autowired
    public QuizQuestionService(QuizQuestionDao quizQuestionDao) {
        this.quizQuestionDao = quizQuestionDao;
    }

    public List<QuizQuestion> getAllQuizQuestions() {
        return quizQuestionDao.getAllQuizQuestions();
    }

    public List<QuizQuestion> getQuizQuestionsByQuizID(int quiz_id) {
        return quizQuestionDao.getQuizQuestionsByQuizId(quiz_id);
    }


    public int countAllQuizQuestions() {
        return getAllQuizQuestions().size();
    }

    public List<QuizQuestion> createQuizQuestions(Quiz quiz, List<Question> questions) {
        List<QuizQuestion> qqs= new ArrayList<>();
        for(int i =0; i < questions.size(); i ++){
            QuizQuestion qq = new QuizQuestion();
            qq.setQuiz_id(quiz.getId());
            qq.setQuestion_id(questions.get(i).getId());
            qq.setOrder_num(i);
            // no
            qqs.add(qq);
        }
        quiz.setQuizQuestions(qqs);
        return qqs;
    }

    public void createQuizQuestions(List<QuizQuestion> qqs) {
        for(QuizQuestion qq: qqs){
            quizQuestionDao.createNewQuizQuestion(qq);
        }
    }






}
