package no.vestein.raspberry.temphumi.command;

import java.util.List;

public class NewReading implements ICommand {

    public void processCommand(List<String> strings) {
        System.out.println("new reading!");
    }

}
