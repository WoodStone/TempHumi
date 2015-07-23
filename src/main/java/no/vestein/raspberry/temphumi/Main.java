package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.Color;
import no.vestein.raspberry.temphumi.command.CommandTask;
import no.vestein.raspberry.temphumi.sensor.SensorTask;

import java.util.Arrays;
import java.util.LinkedList;

public final class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals(Constants.DEV_ARG)) debug();
            else if (args[0].equals(Constants.AUTO_ARG)) auto();
            else pi();
        }
    }

    public static void shutdown() {
        System.exit(0);
    }

    public static void auto() {
        SensorTask sensorTask = new SensorTask(Constants.AUTO_TIME);
        AutoTask autoTask = new AutoTask();

        Thread tSensor = new Thread(sensorTask);
        Thread tAuto = new Thread(autoTask);

        tSensor.start();
        tAuto.start();
    }

    public static void pi() {
        System.out.println("Command Mode");
        System.out.println("Remember '-auto' for Auto Mode");
        SensorTask sensorTask = new SensorTask(Constants.CMD_TIME);
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
