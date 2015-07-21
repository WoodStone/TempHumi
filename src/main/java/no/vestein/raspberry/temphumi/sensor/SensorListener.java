package no.vestein.raspberry.temphumi.sensor;

import java.util.List;

public interface SensorListener {

    void newReading(List<Double> newReading);

}
