package no.vestein.raspberry.temphumi.command;

import java.util.List;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public interface ICommand {

    void processCommand(List<String> strings);
//    String getLegend();

}
