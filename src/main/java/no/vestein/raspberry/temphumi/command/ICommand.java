package no.vestein.raspberry.temphumi.command;

import java.util.List;

public interface ICommand {

    void processCommand(List<String> strings);
//    String getLegend();

}
