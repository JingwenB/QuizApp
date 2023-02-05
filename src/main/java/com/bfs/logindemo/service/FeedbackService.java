package com.bfs.logindemo.service;

import com.bfs.logindemo.dao.FeedbackDao;
import com.bfs.logindemo.dao.UserDao;
import com.bfs.logindemo.domain.Feedback;
import com.bfs.logindemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final FeedbackDao feedbackDao;

    @Autowired
    public FeedbackService(FeedbackDao feedbackDao) { this.feedbackDao = feedbackDao; }

//    public void createNewUser(User user) {
//        userDao.createNewUser(user);
//    }

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
