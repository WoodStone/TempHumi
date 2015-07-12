package no.vestein.raspberry.temphumi;

import java.util.LinkedList;
import java.util.List;

public class SensorData implements  SensorListener {

    private final int listLength;
    private LinkedList<List<Double>> data = new LinkedList<>();

    public SensorData(int listLength) {
        this.listLength = listLength;
    }

    public LinkedList<List<Double>> getData() {
        return data;
    }

    @Override
    public void newReading(List<Double> newReading) {
        if (data.size() == listLength) {
            data.removeFirst();
            data.addLast(newReading);
        } else {
            data.add(newReading);
        }
    }
}
