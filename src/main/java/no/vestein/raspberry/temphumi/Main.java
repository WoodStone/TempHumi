package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.Color;
import no.vestein.raspberry.temphumi.command.CommandTask;
import no.vestein.raspberry.temphumi.sensor.SensorTask;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    private static final boolean debug = false;

    public static void main(String[] args) {
        if (debug) debug();
        else pi();
    }

    public static void shutdown() {
        System.exit(0);
    }

    public static void pi() {
        SensorTask sensorTask = new SensorTask();
        CommandTask commandTask = new CommandTask();

        Thread tCommand = new Thread(commandTask);
        Thread tSensor = new Thread(sensorTask);

        tCommand.start();
        tSensor.start();
    }

    public static void debug() {
        LinkedList<Double> temp = new LinkedList<>(Arrays.asList(20.0, 23.0, 25.0, 26.0, 22.0, 22.0, 25.0, 25.0, 21.0, 15.0, 22.0));
        LinkedList<Double> humi = new LinkedList<>(Arrays.asList(40.0, 50.0, 44.0, 54.0, 53.0, 50.0, 45.0, 43.0, 40.0, 35.0, 40.0));

        DataChart tempChart = new DataChart(0, 40, 0.5, Color.RED, "Temperature", temp);
        DataChart humiChart = new DataChart(20, 80, 1, Color.SKYBLUE, "Humidity", humi);

        System.out.println(tempChart.chart());
        System.out.println(humiChart.chart());
    }

}
