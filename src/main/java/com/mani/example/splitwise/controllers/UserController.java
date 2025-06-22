package com.mani.example.splitwise.controllers;
import com.mani.example.splitwise.dtos.AddMemberRequestDto;
import com.mani.example.splitwise.dtos.AddMemberResponseDto;
import com.mani.example.splitwise.dtos.RegisterUserRequestDto;
import com.mani.example.splitwise.dtos.RegisterUserResponseDto;
import com.mani.example.splitwise.models.User;
import com.mani.example.splitwise.repositories.UserRepository;
import com.mani.example.splitwise.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component  // Since Cmd - Line Execution
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    public UserController(final UserRepository userRepository,UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto){
        return userService.registerUser(requestDto);
    }

    public AddMemberResponseDto addMember(AddMemberRequestDto requestDto){
        return userService.addMember(requestDto);
    }
}
