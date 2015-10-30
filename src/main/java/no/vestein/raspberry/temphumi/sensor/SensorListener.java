package no.vestein.raspberry.temphumi.sensor;

import java.util.List;

/**
 * Represents a listener.
 */
public interface SensorListener {

    void newReading(List<Double> newReading);

}
