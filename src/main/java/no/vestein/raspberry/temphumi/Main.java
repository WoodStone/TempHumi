package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.Color;
import no.vestein.raspberry.temphumi.command.CommandBase;
import no.vestein.raspberry.temphumi.command.CommandHandler;

import java.io.Console;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final boolean debug = false;

    public static void main(String[] args) {
        if (debug) {
            debug();
        } else {
            pi();
        }
    }

    public static void pi() {
        Sensor sensor = new Sensor(11, 4);
        SensorData data = new SensorData(Constants.NUM_OF_READINGS);
        sensor.addListener(data);

        CommandHandler commandHandler = CommandHandler.getInstance();
        commandHandler.registerCommand(new CommandBase() {
            @Override
            public String getName() {
                return "read";
            }

            @Override
            public void processCommand(List<String> strings) {
                for (int i = 0; i < Constants.NUM_OF_READINGS; i++) {
                    sensor.update();
                    System.out.println(data.getTempChart());
                    System.out.println(data.getHumiChart());
                    System.out.println("------------------------");
                    try {
                        Thread.sleep(Constants.SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Console console = System.console();
        while (true) {
            String[] input  = console.readLine().split(" ");
            commandHandler.checkInput(input);
        }
    }

    public static void debug() {
        LinkedList<Double> temp = new LinkedList<>(Arrays.asList(20.0, 23.0, 25.0, 26.0, 22.0, 22.0, 25.0, 25.0, 21.0, 15.0, 22.0));
        LinkedList<Double> humi = new LinkedList<>(Arrays.asList(40.0, 50.0, 44.0, 54.0, 53.0, 50.0, 45.0, 43.0, 40.0, 35.0, 40.0));

        DataChart tempChart = new DataChart(0, 40, 0.5, Color.RED, "Temperature", temp);
        DataChart humiChart = new DataChart(20, 80, 1, Color.SKYBLUE, "Humidity", humi);

        System.out.println(tempChart.chart());
        System.out.println(humiChart.chart());
        System.out.println(100.0 / ((80 - 20) / 10));
    }

}
