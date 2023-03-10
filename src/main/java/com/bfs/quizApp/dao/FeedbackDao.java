package com.bfs.quizApp.dao;

import com.bfs.quizApp.dao.rowMapper.FeedbackRowMapper;
import com.bfs.quizApp.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackDao {

    JdbcTemplate jdbcTemplate;
    FeedbackRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public FeedbackDao(JdbcTemplate jdbcTemplate, FeedbackRowMapper rowMapper,
                       NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Feedback> getAllFeedbacks() {
        String query = "SELECT * FROM Feedback";
        return jdbcTemplate.query(query, rowMapper);
    }

    public void createNewFeedback(Feedback feedback) {
        String query = "INSERT INTO Feedback (user_id, message, rating, date) " +
                "values (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                feedback.getUser_id(),
                feedback.getMessage(),
                feedback.getRating(),
                feedback.getDate());
    }

}
