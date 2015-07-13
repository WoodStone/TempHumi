package no.vestein.raspberry.temphumi;


public class Main {

    public static void main(String[] args) {
        Sensor sensor = new Sensor(11, 4);
        SensorData data = new SensorData(11);

        sensor.addListener(data);

//        while (true) {
//            sensor.update();
//
//            System.out.println(ChartGen.makeChart(data.getData()));
//            try {
//                Thread.sleep(Constants.SLEEP_TIME);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        for (int i = 0; i < 13; i++) {
            sensor.update();
            try {
                Thread.sleep(Constants.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ChartGen.makeChart(data.getData()));
    }

}
