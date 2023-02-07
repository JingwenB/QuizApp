package com.bfs.quizApp.controller.user;

import com.bfs.quizApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactUsController {
    // TODO:Create Service, Dao, Domain
      private final ContactService contactService;

    @Autowired
    public ContactUsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact_us")
    public String getContactUs() {
        return "user/contact_us";
    }

    @PostMapping("/contact_us")
    public String createNewContact(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String subject,
            @RequestParam String message
    ) {
        contactService.createNewContact(firstName, lastName, subject, message);
        return "user/home";
    }


}
