package com.bfs.logindemo.dao.rowMapper;


import com.bfs.logindemo.domain.Quiz;
import com.bfs.logindemo.domain.QuizQuestion;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class QuizRowMapper implements RowMapper<Quiz> {
    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz qq = new Quiz();

        qq.setId(rs.getInt("quiz_id"));
        qq.setUser_id(rs.getInt("user_id"));
        qq.setCategory(rs.getString("category"));
        qq.setName(rs.getString("name"));
        qq.setTime_start(rs.getTimestamp("time_start"));
        qq.setTime_end(rs.getTimestamp("time_end"));
        return qq;
    }
}
