package com.sec.secdailycodework.controller;

import com.sec.secdailycodework.dto.RegistrationRequest;
import com.sec.secdailycodework.event.RegistrationCompleteEvent;
import com.sec.secdailycodework.models.User;
import com.sec.secdailycodework.service.UserServiceInterface;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final UserServiceInterface service;
    private final ApplicationEventPublisher publisher;

    public RegistrationController(UserServiceInterface service,ApplicationEventPublisher publisher){
        this.service=service;
        this.publisher=publisher;
    }
    @PostMapping
    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user =service.registerUser(registrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "success! please check your email for verification";
    }

    public  String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}
