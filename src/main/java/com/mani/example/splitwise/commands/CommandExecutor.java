package com.mani.example.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private  AddMemberCommand  addMemberCommand;
    private  AddGroupCommand addGroupCommand;
    private  RegisterUserCommand registerUserCommand;
    private  SettleUpUserCommand settleUpUserCommand;

    private List<Command> commands = new ArrayList<>();

    public CommandExecutor(AddMemberCommand addMemberCommand,
                           AddGroupCommand addGroupCommand,
                           RegisterUserCommand registerUserCommand,
                           SettleUpUserCommand settleUpUserCommand) {
        this.addMemberCommand = addMemberCommand;
        this.addGroupCommand = addGroupCommand;
        this.registerUserCommand = registerUserCommand;
        this.settleUpUserCommand = settleUpUserCommand;
        commands.add(addMemberCommand);
        commands.add(addGroupCommand);
        commands.add(registerUserCommand);
        commands.add(settleUpUserCommand);
    }


    public void addCommand(Command command) {
        commands.add(command);
    }
    public void removeCommmand(Command command) {
        commands.remove(command);
    }
    public void execute(String input) {
        for (Command command : commands) {
            if(command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
