package com.bfs.logindemo.controller;

import com.bfs.logindemo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {
    // TODO:Create Service
//    private final ContactUsService contactUsService;

    @Autowired
    public ContactUsController() {
    }

    @GetMapping("/contact_us")
    public String getContactUs() {
        return "contact_us";
    }


}
