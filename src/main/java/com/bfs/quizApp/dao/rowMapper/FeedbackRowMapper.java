package com.bfs.quizApp.dao.rowMapper;

import com.bfs.quizApp.domain.Feedback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FeedbackRowMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setId(rs.getInt("feedback_id"));
        feedback.setUser_id(rs.getInt("user_id"));
        feedback.setMessage(rs.getString("message"));
        feedback.setRating(rs.getInt("rating"));
        feedback.setDate(rs.getDate("date"));

        return feedback;
    }


}
