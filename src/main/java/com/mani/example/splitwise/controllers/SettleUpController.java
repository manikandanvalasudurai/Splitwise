package com.mani.example.splitwise.controllers;

import com.mani.example.splitwise.dtos.SettleUpGroupRequestDto;
import com.mani.example.splitwise.dtos.SettleUpGroupResponseDto;
import com.mani.example.splitwise.dtos.SettleUpUserRequestDto;
import com.mani.example.splitwise.dtos.SettleUpUserResponseDto;
import com.mani.example.splitwise.models.User;
import com.mani.example.splitwise.services.SettleupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settleUp")
public class SettleUpController {
    private SettleupService settleupService;

    public SettleUpController(SettleupService settleupService) {
        this.settleupService = settleupService;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto) {
        return null;
    }
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto requestDto) {
        return null;
    }
}
