package no.vestein.raspberry.temphumi.sensor;

import no.vestein.raspberry.temphumi.Constants;

import java.util.concurrent.TimeUnit;

public final class SensorTask implements Runnable {

    private static Sensor sensor = new Sensor(11, 4);
    private static SensorData data = new SensorData(Constants.NUM_OF_READINGS);

    @Override
    public void run() {
        //TODO implement thread for data mining
        sensor.addListener(data);
        try {
            sensor.update();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SensorData getData() {
        return data;
    }

}
