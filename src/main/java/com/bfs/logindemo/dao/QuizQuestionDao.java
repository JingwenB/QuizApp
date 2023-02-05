package com.bfs.logindemo.dao;

import com.bfs.logindemo.dao.rowMapper.QuizQuestionRowMapper;
import com.bfs.logindemo.domain.Choice;
import com.bfs.logindemo.domain.Question;
import com.bfs.logindemo.domain.Quiz;
import com.bfs.logindemo.domain.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizQuestionDao {

    JdbcTemplate jdbcTemplate;
    QuizQuestionRowMapper qqRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuizQuestionDao(JdbcTemplate jdbcTemplate,
                           QuizQuestionRowMapper qqRowMapper,
                           NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.qqRowMapper = qqRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<QuizQuestion> getAllQuizQuestions() {
        String query = "SELECT * FROM QuizQuestion";
        List<QuizQuestion> qqs =  jdbcTemplate.query(query, qqRowMapper);
        return qqs;
    }

    public void createNewQuizQuestion(QuizQuestion qq){
        String query =
                "INSERT INTO QuizQuestion ( " +
                        "quiz_id, " +
                        "question_id, " +
                        "user_choice_id, " +
                        "order_num) " +
                        "values (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                qq.getQuiz_id(),
                qq.getQuestion_id(),
                qq.getUser_choice_id(),
                qq.getOrder_num()
        );
    }

    public List<QuizQuestion> getQuizQuestionsByQuizId(int quiz_id) {

        String query = "SELECT * FROM QuizQuestion where quiz_id = (:quiz_id) ORDER BY order_num asc";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("quiz_id", quiz_id);
        return namedParameterJdbcTemplate.query(query, parameterSource, qqRowMapper);

    }

}