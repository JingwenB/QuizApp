package com.bfs.logindemo.dao;

import com.bfs.logindemo.dao.rowMapper.UserRowMapper;
import com.bfs.logindemo.domain.User;
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
        String query = "SELECT * FROM User" +
                " WHERE is_active is true and is_admin is false";
        return jdbcTemplate.query(query, rowMapper);
    }

    public void createNewUser(String email, String password, String firstName, String lastName) {
        String query = "INSERT INTO user (firstName, lastName, email, password) values (?, ?, ?, ?)";
        jdbcTemplate.update(query, firstName, lastName, email, password);
    }
}
