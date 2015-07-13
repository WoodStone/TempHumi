package no.vestein.raspberry.temphumi;


import com.googlecode.charts4j.Color;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        Sensor sensor = new Sensor(11, 4);
//        SensorData data = new SensorData(Constants.NUM_OF_READINGS);
//
//        sensor.addListener(data);

//        while (true) {
//            sensor.update();
//
//            System.out.println(ChartGen.makeChart(data.getData()));
//            try {
//                Thread.sleep(Constants.SLEEP_TIME);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        for (int i = 0; i < 13; i++) {
//            sensor.update();
//            try {
//                Thread.sleep(Constants.SLEEP_TIME);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(ChartGen.makeChart(data.getData()));

        LinkedList<Double> temp = new LinkedList<>(Arrays.asList(20.0, 23.0, 25.0, 26.0, 22.0, 22.0, 25.0, 25.0, 21.0, 15.0, 22.0));
        LinkedList<Double> humi = new LinkedList<>(Arrays.asList(40.0, 50.0, 44.0, 54.0, 53.0, 50.0, 45.0, 43.0, 40.0, 35.0, 40.0));

        DataChart tempChart = new DataChart(0, 40, 0.5, Color.RED, "Temperature", temp);
        DataChart humiChart = new DataChart(20, 80, 1, Color.SKYBLUE, "Humidity", humi);

        System.out.println(tempChart.chart());
        System.out.println(humiChart.chart());
        System.out.println(100.0 / ((80 - 20) / 10));
    }

}
