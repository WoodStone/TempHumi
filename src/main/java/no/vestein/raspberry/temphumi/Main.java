package no.vestein.raspberry.temphumi;


public class Main {

    public static void main(String[] args) {
        Sensor sensor = new Sensor(11, 4);
        SensorData data = new SensorData(10);

        sensor.addListener(data);

        while (true) {
            sensor.update();

            try {
                Thread.sleep(Constants.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
