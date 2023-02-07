package com.bfs.quizApp.dao;

import com.bfs.quizApp.dao.rowMapper.ChoiceRowMapper;
import com.bfs.quizApp.domain.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceDao {

    JdbcTemplate jdbcTemplate;
    ChoiceRowMapper choiceRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ChoiceDao(JdbcTemplate jdbcTemplate,
                     ChoiceRowMapper choiceRowMapper,
                     NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.choiceRowMapper = choiceRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    public Choice getChoiceByChoiceID(int choice_id) {
        String query = "SELECT * FROM Choice WHERE choice_id = (:choice_id)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("choice_id", choice_id);

        List<Choice> choices =  namedParameterJdbcTemplate.query(query, parameterSource, choiceRowMapper);

        return choices.size() == 0 ? null : choices.get(0);
    }

    public List<Choice> getChoicesByQuestionID(int question_id) {
        String query = "SELECT * FROM Choice WHERE question_id = (:question_id)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question_id", question_id);
        List<Choice> choices = namedParameterJdbcTemplate.query(query, parameterSource, choiceRowMapper);
        return choices;
    }


    public void createChoicesWithQuestionID(Choice choice) {
        String query = "INSERT INTO Choice (question_id, description, is_correct) " +
                "values (?, ?, ?)";
        jdbcTemplate.update(query, choice.getQuestion_id(),
                choice.getDescription(),choice.isCorrect());
    }

    public void updateChoice(Choice choice) {
        String query = "update Choice set description = ?, is_correct = ? where choice_id = ?;";
        jdbcTemplate.update(query, choice.getDescription(), choice.isCorrect(), choice.getId());
    }
}
