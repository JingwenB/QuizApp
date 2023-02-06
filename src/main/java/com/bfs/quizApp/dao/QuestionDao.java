package com.bfs.quizApp.dao;

import com.bfs.quizApp.dao.rowMapper.QuestionRowMapper;
import com.bfs.quizApp.domain.Choice;
import com.bfs.quizApp.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {

    JdbcTemplate jdbcTemplate;
    QuestionRowMapper questionRowMapper;
    ChoiceDao choiceDao;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate,
                       QuestionRowMapper questionRowMapper,
                       ChoiceDao choiceDao,
                   NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionRowMapper = questionRowMapper;
        this.choiceDao = choiceDao;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Question> getQuestionsByCategory(String category) {
        String query = "SELECT * FROM Question WHERE category = (:category)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("category", category);
        List<Question> questions = namedParameterJdbcTemplate.query(query, parameterSource, questionRowMapper);
        questions.stream().forEach(this::setQuestionChoices);
        return questions;
    }
    public List<Question> getActiveQuestionsByCategory(String category) {
        String query = "SELECT * FROM Question WHERE category = (:category) and is_active = true";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("category", category);
        List<Question> questions = namedParameterJdbcTemplate.query(query, parameterSource, questionRowMapper);
        questions.stream().forEach(this::setQuestionChoices);
        return questions;
    }


    public Question getQuestionByQuestionId(int id) {
        String query = "SELECT * FROM Question WHERE question_id = (:id) ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        List<Question> questions =  namedParameterJdbcTemplate.query(query,parameterSource, questionRowMapper);
        Question question= null;
        if(questions.size() != 0){
            question = questions.get(0);
            setQuestionChoices(question);
        }
        return question;
    }

    private void setQuestionChoices(Question question){
        List<Choice> choices = choiceDao.getChoicesByQuestionID(question.getId());
        question.setChoices(choices);
        question.setCorrect_choice();

    }

    public List<Question> getAllQuestions() {
        String query = "SELECT * FROM Question";
        List<Question> questions = namedParameterJdbcTemplate.query(query, questionRowMapper);
        questions.stream().forEach(this::setQuestionChoices);
        return questions;
    }

    public List<Question> getAllActiveQuestions() {
        String query = "SELECT * FROM Question where is_active = true";
        List<Question> questions = namedParameterJdbcTemplate.query(query, questionRowMapper);
        questions.stream().forEach(this::setQuestionChoices);
        return questions;
    }

    public void activateQuestion(String question_id) {
        String query = "update Question set is_active = true where question_id = ?;";
        jdbcTemplate.update(query, question_id);
    }

    public void deactivateQuestion(String question_id) {
        String query = "update Question set is_active = false where question_id = ?;";
        jdbcTemplate.update(query, question_id);
    }
}
