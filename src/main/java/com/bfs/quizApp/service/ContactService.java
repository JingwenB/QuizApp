package com.bfs.quizApp.service;

import com.bfs.quizApp.dao.ContactDao;
import com.bfs.quizApp.dao.FeedbackDao;
import com.bfs.quizApp.domain.Contact;
import com.bfs.quizApp.domain.Feedback;
import com.bfs.quizApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ContactService {
    private final ContactDao contactDao;

    @Autowired
    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void createNewContact(String firstName, String lastName, String subject, String message) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setSubject(subject);
        contact.setMessage(message);
        contactDao.createNewContact(contact);
    }
}
