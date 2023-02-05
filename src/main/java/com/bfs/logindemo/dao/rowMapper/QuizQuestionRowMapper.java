package com.bfs.logindemo.dao.rowMapper;

import com.bfs.logindemo.domain.QuizQuestion;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizQuestionRowMapper implements RowMapper<QuizQuestion> {
    @Override
    public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizQuestion qq = new QuizQuestion();

        qq.setId(rs.getInt("qq_id"));
        qq.setQuiz_id(rs.getInt("quiz_id"));
        qq.setQuestion_id(rs.getInt("question_id"));
        qq.setUser_choice_id(rs.getInt("user_choice_id"));
        qq.setOrder_num(rs.getInt("order_num"));

        return qq;
    }
}
