package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.FeedbackDao;
import com.bfs.quizApp.dao.UserDao;
import com.bfs.quizApp.domain.Feedback;
import com.bfs.quizApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackDao feedbackDao;
    private final UserService userService;

    @Autowired
    public FeedbackService(FeedbackDao feedbackDao,
                           UserService userService) {
        this.feedbackDao = feedbackDao;
        this.userService = userService;
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    public void createNewFeedback(Integer star, String message, User user) {
        Feedback feedback = new Feedback();
        feedback.setRating(star);
        feedback.setMessage(message);
        feedback.setUser_id(user.getId());
        feedback.setDate(new Date(System.currentTimeMillis()));
        feedbackDao.createNewFeedback(feedback);

    }

    public void setUser(Feedback fb) {
        fb.setUser(userService.getUserById(fb.getUser_id()));
    }
}
