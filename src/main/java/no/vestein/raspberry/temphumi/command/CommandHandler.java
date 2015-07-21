package no.vestein.raspberry.temphumi.command;

import java.util.*;

public class CommandHandler {

    private Map<String, ICommand> commandMap = new HashMap<>();
    private static CommandHandler instance = new CommandHandler();

    public static CommandHandler getInstance() {
        return instance;
    }

    private CommandHandler() {

    }

    public void registerCommand(String legend, ICommand command) {
        if (commandMap.containsKey(legend)) return;
        commandMap.put(legend, command);
    }

    public void checkInput(String[] input) {
        List<String> command = Arrays.asList(input);
        for (String name : commandMap.keySet()) {
            if (command.get(0).toLowerCase().equals(name)) {
                List<String> args = new ArrayList<>();
                if (command.size() > 1) {
                    args = command.subList(1, command.size());
                }
                commandMap.get(name).processCommand(args);
                return;
            }
        }
        System.out.println("Unknown command");
    }

    public void checkInput(ArrayList<String> input) {
        checkInput((String[]) input.toArray());
    }

}
