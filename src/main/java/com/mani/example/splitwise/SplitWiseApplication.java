package com.mani.example.splitwise;

import com.mani.example.splitwise.commands.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitWiseApplication {
    private static CommandExecutor commandExecutor;

    public SplitWiseApplication(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Hey there..! Waiting for User Input ->");
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }
    }
}
