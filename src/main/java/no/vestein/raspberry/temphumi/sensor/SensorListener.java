package no.vestein.raspberry.temphumi.sensor;

import java.util.List;

public interface SensorListener {

    public void newReading(List<Double> newReading);

}
