package com.bfs.logindemo.service;

import com.bfs.logindemo.dao.QuestionDao;
import com.bfs.logindemo.dao.QuizDao;
import com.bfs.logindemo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizDao quizDao;


    @Autowired
    public QuizService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    public List<Quiz> getQuizzesByUserID(int userId) {
        return quizDao.getQuizzesByUserId(userId);
    }

    public List<Quiz> getAllQuizzes() {
        return quizDao.getAllQuizzes();
    }

    public int countAllQuizzes() {
        return quizDao.getAllQuizzes().size();
    }

    public void createNewQuizToDB(Quiz quiz) {

          quizDao.createNewQuiz(quiz);

    }



    public Quiz createNewQuizInSession(HttpSession session) {
        Quiz quiz = new Quiz();
        int id = countAllQuizzes() + 1;
        User u = (User) session.getAttribute("user");
        String category = (String) session.getAttribute("category");
        quiz.setId(id);
        quiz.setUser(u);
        quiz.setUser_id(u.getId());
        quiz.setCategory(category);
        quiz.setName(u.getFirstName()
                +"'s " + category + " quiz");
        quiz.setTime_start(new Timestamp(System.currentTimeMillis()));
        return quiz;
    }


    public Quiz updateSelection(Quiz quiz, Integer questionId, Integer selectedChoiceId) {
       List<QuizQuestion> qqs = quiz.getQuizQuestions();
        for (QuizQuestion qq : qqs) {
            if (qq.getQuestion_id() == questionId) {
                qq.setUser_choice_id(selectedChoiceId);
            }
        }
       return quiz;
    }

    public Quiz submitQuiz(Quiz quiz) {
        quiz.setTime_end(new Timestamp(System.currentTimeMillis()));
        createNewQuizToDB(quiz);

        return quiz;
    }

    public Quiz getQuizzesByQuizID(Integer quiz_id) {
        return quizDao.getQuizzesByQuizID(quiz_id);
    }
}