package com.mani.example.splitwise.dtos;

import com.mani.example.splitwise.models.User;

public class RegisterUserResponseDto {
    private User user;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
