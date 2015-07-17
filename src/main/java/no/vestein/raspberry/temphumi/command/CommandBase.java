package no.vestein.raspberry.temphumi.command;

import java.util.List;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public abstract class CommandBase {

    public abstract String getName();
    public abstract void processCommand(List<String> strings);

    public String getUsage() {
        return null;
    }

}
