package com.mani.example.splitwise.services;

import com.mani.example.splitwise.dtos.AddMemberRequestDto;
import com.mani.example.splitwise.dtos.AddMemberResponseDto;
import com.mani.example.splitwise.dtos.RegisterUserRequestDto;
import com.mani.example.splitwise.dtos.RegisterUserResponseDto;
import com.mani.example.splitwise.models.User;
import com.mani.example.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getUsername());
        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setPassword(requestDto.getPassword());
        userRepository.save(user);
        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        responseDto.setUser(user);
        responseDto.setMessage("User " + user.getName() + " registered successfully with phone " + user.getPhoneNumber() + "!");
        return responseDto;
    }
    public AddMemberResponseDto addMember(AddMemberRequestDto resquesdto ){
        /*
        1.Fetch Group with Group ID
        2.Admin with Admin ID
        3.User with UserID
        4.Check Group Admin is == Admin from DataBase or Not if Not Through UnAuthorised Exception
        5.If yes Then add a Member as Groups.getList in that List add this Member or User and Save to the DB
         */
        return null;
    }
}
