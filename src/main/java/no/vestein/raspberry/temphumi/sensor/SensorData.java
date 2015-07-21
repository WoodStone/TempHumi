package no.vestein.raspberry.temphumi.sensor;

import com.googlecode.charts4j.Color;
import no.vestein.raspberry.temphumi.DataChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SensorData implements SensorListener {

    private final int listLength;
    private LinkedList<Double> tempData = new LinkedList<>();
    private LinkedList<Double> humiData = new LinkedList<>();
    private DataChart tempChart = new DataChart(0, 40, 0.5, Color.RED, "Temperature", tempData);
    private DataChart humiChart = new DataChart(20, 80, 1, Color.SKYBLUE, "Humidity", humiData);

    public SensorData(int listLength) {
        this.listLength = listLength;
    }

    public ArrayList<LinkedList<Double>> getData() {
        ArrayList<LinkedList<Double>> data = new ArrayList<>();
        data.add(tempData);
        data.add(humiData);
        return data;
    }

    public LinkedList<Double> getTempData() {
        return tempData;
    }

    public LinkedList<Double> getHumiData() {
        return humiData;
    }

    public String getTempChart() {
        return tempChart.chart();
    }

    public String getHumiChart() {
        return humiChart.chart();
    }

    @Override
    public void newReading(List<Double> newReading) {
        if (tempData.size() == listLength) {
            tempData.removeFirst();
            humiData.removeFirst();
            tempData.addLast(newReading.get(0));
            humiData.addLast(newReading.get(1));
        } else {
            tempData.add(newReading.get(0));
            humiData.add(newReading.get(1));
        }
    }
}
