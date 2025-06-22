package com.mani.example.splitwise.commands;
import com.mani.example.splitwise.controllers.UserController;
import com.mani.example.splitwise.dtos.RegisterUserRequestDto;
import com.mani.example.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    private UserController userController;
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }
    /*
        Register vinsmokesanji 003 namisswwaann

        u1 is registering with the username "vinsmokesanji", phone "003" and password as "namisswwaann"
     */
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" ")); //all the individual words --> Register vinsmokesanji 003 namisswwaann
        return words.size() == 4 && words.get(0).matches(CommandKeywords.registerCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setUsername(words.get(1));
        requestDto.setPassword(words.get(3));
        requestDto.setPhoneNumber(words.get(2));
        RegisterUserResponseDto responseDto = userController.registerUser(requestDto);
        System.out.println(responseDto.getMessage());
    }
}
