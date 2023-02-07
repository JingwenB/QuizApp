package com.bfs.quizApp.dao;

import com.bfs.quizApp.dao.rowMapper.ContactUsRowMapper;
import com.bfs.quizApp.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDao {

    JdbcTemplate jdbcTemplate;
    ContactUsRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContactDao(JdbcTemplate jdbcTemplate,
                      ContactUsRowMapper rowMapper,
                      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Contact> getAllContacts() {
        String query = "SELECT * FROM Contact";
        return jdbcTemplate.query(query, rowMapper);
    }


    public void createNewContact(Contact contact) {
        String query = "INSERT INTO Contact (firstName, lastName, subject, message) " +
                "values (?, ?, ?, ?)";
        jdbcTemplate.update(query, contact.getFirstName(), contact.getLastName(),
                contact.getSubject(), contact.getMessage());
    }
}
