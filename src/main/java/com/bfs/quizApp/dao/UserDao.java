package com.bfs.quizApp.dao;

import com.bfs.quizApp.dao.rowMapper.UserRowMapper;
import com.bfs.quizApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    JdbcTemplate jdbcTemplate;
    UserRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate, UserRowMapper rowMapper,
                   NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM User";
        return jdbcTemplate.query(query, rowMapper);
    }

    public void createNewUser(String email, String password, String firstName, String lastName) {
        String query = "INSERT INTO user (firstName, lastName, email, password) " +
                "values (?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, password);
    }

    public void activateUser(String user_id) {
        String query = "update user set is_active = true where user_id = ?;";
        jdbcTemplate.update(query, user_id);
    }

    public void deactivateUser(String user_id) {
        String query = "update user set is_active = false where user_id = ?;";
        jdbcTemplate.update(query, user_id);
    }
}
