package com.bfs.quizApp.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {
    // TODO:Create Service, Dao, Domain
    //  private final ContactUsService contactUsService;

    @Autowired
    public ContactUsController() {
    }

    @GetMapping("/contact_us")
    public String getContactUs() {
        return "user/contact_us";
    }


}
