package com.bfs.logindemo.dao.rowMapper;

import com.bfs.logindemo.domain.Question;
import com.bfs.logindemo.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();

        question.setId(rs.getInt("question_id"));
        question.setCategory(rs.getString("category"));
        question.setDescription(rs.getString("description"));
        // todo is_active == int ??
        question.setIs_active(rs.getInt("is_active"));
        return question;
    }
}
