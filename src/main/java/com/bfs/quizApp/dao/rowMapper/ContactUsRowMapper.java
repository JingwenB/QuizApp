package com.bfs.quizApp.dao.rowMapper;

import com.bfs.quizApp.domain.Contact;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContactUsRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt("contact_id"));
        contact.setMessage(rs.getString("message"));
        contact.setFirstName(rs.getString("firstName"));
        contact.setLastName(rs.getString("lastName"));
        contact.setLastName(rs.getString("subject"));
        return contact;
    }


}
