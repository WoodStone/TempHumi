package no.vestein.raspberry.temphumi.sensor;

import no.vestein.raspberry.temphumi.Constants;

import java.util.concurrent.TimeUnit;

public final class SensorTask implements Runnable {

    private static final Sensor sensor = new Sensor(11, 4);
    public static final SensorData data = new SensorData(Constants.NUM_OF_READINGS);

    @Override
    public void run() {
        sensor.addListener(data);
        try {
            while (!Thread.interrupted()) {
                sensor.update();
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
