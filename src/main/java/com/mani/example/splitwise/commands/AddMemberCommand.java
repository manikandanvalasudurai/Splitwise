package com.mani.example.splitwise.commands;

import com.mani.example.splitwise.controllers.UserController;
import com.mani.example.splitwise.dtos.AddMemberRequestDto;
import com.mani.example.splitwise.dtos.AddMemberResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddMemberCommand implements Command {
    private UserController userController;
    public AddMemberCommand(UserController userController) {
        this.userController = userController;
    }
    /*
    u1 AddMember g1 u2

    u1 is adding u2 as a member of the group "Roommates" (which has the id g1)
     */
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(1).equals(CommandKeywords.addMemberCommand);
    }
    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        //check user u1 is a Admin or Not then only he/she can add the u2 as a member
        Long admin = Long.valueOf(words.get(0));
        Long groupId = Long.valueOf(words.get(2));
        Long userId = Long.valueOf(words.get(3));

        AddMemberRequestDto requestDto = new AddMemberRequestDto();
        requestDto.setAdminId(admin);
        requestDto.setGroupId(groupId);
        requestDto.setUserId(userId);
        AddMemberResponseDto responseDto = userController.addMember(requestDto);
        System.out.println(responseDto.getMessage());
    }
}
