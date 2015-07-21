package no.vestein.raspberry.temphumi.command;

import no.vestein.raspberry.temphumi.sensor.SensorTask;

import java.util.List;

public class GetGraphs implements ICommand {

    public void processCommand(List<String> strings) {
        System.out.println("-------------------------");
        System.out.println(SensorTask.data.getTempChart());
        System.out.println(SensorTask.data.getHumiChart());
        System.out.println("-------------------------");
    }

}
