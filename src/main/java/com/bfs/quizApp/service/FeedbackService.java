package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.FeedbackDao;
import com.bfs.quizApp.domain.Feedback;
import com.bfs.quizApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackDao feedbackDao;

    @Autowired
    public FeedbackService(FeedbackDao feedbackDao) { this.feedbackDao = feedbackDao; }



    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    public void createNewFeedback(Integer star, String message, User user) {
        Feedback feedback = new Feedback();
        feedback.setRating(star);
        feedback.setMessage(message);
        feedback.setUser_id(user.getId());
        feedback.setDate(new Timestamp(System.currentTimeMillis()));
        feedbackDao.createNewFeedback(feedback);

    }
}
