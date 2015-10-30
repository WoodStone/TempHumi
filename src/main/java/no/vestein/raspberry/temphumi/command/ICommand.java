package no.vestein.raspberry.temphumi.command;

import java.util.List;

/**
 * Represents a command
 */
public interface ICommand {

    void processCommand(List<String> strings);

}
