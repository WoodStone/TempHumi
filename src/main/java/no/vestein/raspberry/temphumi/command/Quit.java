package no.vestein.raspberry.temphumi.command;

import no.vestein.raspberry.temphumi.Main;

import java.util.List;

public class Quit implements ICommand {

    @Override
    public void processCommand(List<String> strings) {
        Main.shutdown();
    }

}
