package com.bfs.logindemo.dao.rowMapper;

import com.bfs.logindemo.domain.Choice;
import com.bfs.logindemo.domain.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ChoiceRowMapper implements RowMapper<Choice> {
    @Override
    public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Choice choice = new Choice();

        choice.setId(rs.getInt("choice_id"));
        choice.setQuestion_id(rs.getInt("question_id"));
        choice.setDescription(rs.getString("description"));
        //TODO 是不是要用setIs_correct, 前端有用过，check to change
        choice.setCorrect(rs.getBoolean("is_correct"));
        return choice;
    }
}
