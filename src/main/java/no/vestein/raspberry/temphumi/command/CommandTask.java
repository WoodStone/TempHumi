package no.vestein.raspberry.temphumi.command;

import java.io.Console;

public class CommandTask implements Runnable {

    @Override
    public void run() {
        EnumCommand.init();
        Console console = System.console();
        while (!Thread.interrupted()) {
            System.out.print("Command: ");
            CommandHandler.getInstance().checkInput(console.readLine().split(" "));
        }
    }

}
