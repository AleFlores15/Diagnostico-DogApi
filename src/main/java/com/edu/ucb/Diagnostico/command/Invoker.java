package com.edu.ucb.Diagnostico.command;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Invoker {

    private final List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands(Long petId) {
        for (Command command : commandList) {
            command.execute(petId);
        }
        commandList.clear();
    }
}