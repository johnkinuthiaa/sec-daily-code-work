package com.sec.secdailycodework.service;

import com.sec.secdailycodework.dto.RegistrationRequest;
import com.sec.secdailycodework.models.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);
}
