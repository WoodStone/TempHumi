package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.Color;
import no.vestein.raspberry.temphumi.command.CommandTask;
import no.vestein.raspberry.temphumi.sensor.SensorTask;

import java.util.LinkedList;

public final class Main {

    public static void main(String... args) {
        if (args.length > 0) {
            switch (args[0]){
                case Constants.DEV_ARG:
                    debug();
                    break;
                case Constants.AUTO_ARG:
                    auto();
                    break;
                default:
                    pi();
            }
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
        LinkedList<Double> temp = new LinkedList<>();
        LinkedList<Double> humi = new LinkedList<>();
        for (int i=0; i < Constants.NUM_OF_READINGS; i++) {
            temp.add((double) Util.randInt(20, 30));
            humi.add((double) Util.randInt(40, 50));
        }

        DataChart tempChart = new DataChart(0, 40, 0.5, Color.RED, "Temperature", temp);
        DataChart humiChart = new DataChart(20, 80, 1, Color.SKYBLUE, "Humidity", humi);

        System.out.println(tempChart.chart());
        System.out.println(humiChart.chart());
    }

}
