package com.sec.secdailycodework.service;

import com.sec.secdailycodework.dto.RegistrationRequest;
import com.sec.secdailycodework.models.User;
import com.sec.secdailycodework.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserServiceInterface{
    private final UserRepository repository;
    private final UserRepository userRepository;

    public UserService(UserRepository repository, UserRepository userRepository){
        this.repository=repository;
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> user =userRepository.findByEmail(request.email());
        if(user.isPresent()){
            throw new RuntimeException("user with email"+request.email()+" already exists");
        }
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
