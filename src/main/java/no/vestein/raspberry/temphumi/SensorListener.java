package no.vestein.raspberry.temphumi;

import java.util.List;

public interface SensorListener {

    public void newReading(List<Double> newReading);

}
