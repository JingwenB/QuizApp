package com.bfs.logindemo.dao;

import com.bfs.logindemo.dao.rowMapper.QuizRowMapper;
import com.bfs.logindemo.domain.Question;
import com.bfs.logindemo.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class QuizDao {

    JdbcTemplate jdbcTemplate;
    QuizRowMapper quizRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuizDao(JdbcTemplate jdbcTemplate, QuizRowMapper quizRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.quizRowMapper = quizRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public int createNewQuiz(Quiz quiz){
        String query =
                "INSERT INTO Quiz (quiz_id, " +
                        "user_id, " +
                        "category, " +
                        "name, " +
                        "time_start," +
                        "time_end) " +
                        "values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                quiz.getId(),
                quiz.getUser_id(),
                quiz.getCategory(),
                quiz.getName(),
                quiz.getTime_start(),
                quiz.getTime_end()
        );
        return quiz.getId();
    }

    public List<Quiz> getQuizzesByUserId(Integer userId) {
        String query = "SELECT * FROM Quiz WHERE user_id = (:id) and time_end is not null";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", userId);

        List<Quiz> quizzes =  namedParameterJdbcTemplate.query(query, parameterSource, quizRowMapper);
        return quizzes;
    }

    public List<Quiz> getAllQuizzes() {
        String query = "SELECT * FROM Quiz";

        List<Quiz> quizzes =  jdbcTemplate.query(query, quizRowMapper);
        return quizzes;
    }

    public Quiz getQuizzesByQuizID(Integer quiz_id) {
        String query = "SELECT * FROM Quiz WHERE quiz_id = (:quiz_id)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("quiz_id", quiz_id);
        List<Quiz> quizzes =  namedParameterJdbcTemplate.query(query, parameterSource, quizRowMapper);
        return quizzes.get(0);
    }
}
