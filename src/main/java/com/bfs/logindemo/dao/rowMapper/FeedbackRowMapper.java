package com.bfs.logindemo.dao.rowMapper;

import com.bfs.logindemo.domain.Feedback;
import com.bfs.logindemo.domain.User;
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
        feedback.setDate(rs.getTimestamp("timestamp"));

        return feedback;
    }


}
