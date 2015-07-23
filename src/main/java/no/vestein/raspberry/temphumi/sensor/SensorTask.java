package no.vestein.raspberry.temphumi.sensor;

import no.vestein.raspberry.temphumi.Constants;

import java.util.concurrent.TimeUnit;

public final class SensorTask implements Runnable {

    private final int updateTime;
    private static final Sensor sensor = new Sensor(11, 4);
    public static final SensorData data = new SensorData(Constants.NUM_OF_READINGS);

    public SensorTask(int updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public void run() {
        sensor.addListener(data);
        try {
            while (!Thread.interrupted()) {
                sensor.update();
                TimeUnit.SECONDS.sleep(updateTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
