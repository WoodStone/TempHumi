package no.vestein.raspberry.temphumi.command;

import java.io.Console;

public final class CommandTask implements Runnable {

    @Override
    public void run() {
        EnumCommand.init();
        Console console = System.console();
        while (!Thread.interrupted()) {
            System.out.print("Command: ");
            CommandHandler.instance().checkInput(console.readLine().split(" "));
        }
    }

}
