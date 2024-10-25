package com.sec.secdailycodework.controller;

import com.sec.secdailycodework.models.User;
import com.sec.secdailycodework.service.UserService;
import com.sec.secdailycodework.service.UserServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceInterface service;
    public UserController(UserServiceInterface service){
        this.service=service;
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getUsers();
    }
}
