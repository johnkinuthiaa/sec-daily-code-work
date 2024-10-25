package com.sec.secdailycodework.dto;


public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role
) {

}
