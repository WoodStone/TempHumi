package no.vestein.raspberry.temphumi;

import java.util.LinkedList;
import java.util.List;

public class raspChart implements  SensorListener {

    private LinkedList<List<Double>> data = new LinkedList<>();

    public raspChart() {

    }

    @Override
    public void newReading(List<Double> newReading) {

    }
}
