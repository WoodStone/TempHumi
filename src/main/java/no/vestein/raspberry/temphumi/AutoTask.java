package no.vestein.raspberry.temphumi;

import no.vestein.raspberry.temphumi.sensor.SensorTask;

import java.util.concurrent.TimeUnit;

public class AutoTask implements Runnable {
    
    private final ChartFile file = new ChartFile("charts");

    @Override
    public void run() {
        try {
            updateFile();
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            //Nothing
        }
    }

    private void updateFile() {
        String temp = "Temperature=" + SensorTask.data.getTempChart() + "\n";
        String humi = "Humidity=" + SensorTask.data.getHumiChart() + "\n";
        String s = temp + humi;
        file.updateFile(s);
    }

}
