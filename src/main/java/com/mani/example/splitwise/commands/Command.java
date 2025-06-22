package com.mani.example.splitwise.commands;

public interface Command {
    //just check whether the given ip string is matching with particular command or not
    boolean matches(String input);

    void execute(String input);

}
