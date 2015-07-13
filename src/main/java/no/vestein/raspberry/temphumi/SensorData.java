package no.vestein.raspberry.temphumi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SensorData implements  SensorListener {

    private final int listLength;
    private LinkedList<Double> tempData = new LinkedList<>();
    private LinkedList<Double> humiData = new LinkedList<>();

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
