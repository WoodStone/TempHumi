package no.vestein.raspberry.temphumi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sensor {

    private ArrayList<SensorListener> listeners = new ArrayList<>();
    private final int type;
    private final int pin;

    public Sensor(int type, int pin) {
        if (type != 11) throw new IllegalArgumentException("Type should be 11");
        this.type = type;
        this.pin = pin;
    }

    public void update() {
        updateListeners(newReading());
    }

    private List<Double> newReading() {
        String cmd = "sudo python DHT.py " + type + " " + pin;
        try {
            Process p = Runtime.getRuntime().exec(cmd.split(" "));
            p.waitFor();
            Scanner scanner = new Scanner(p.getInputStream());
            List<Double> reading = new ArrayList<>();
            while (scanner.hasNextDouble()) {
                reading.add(scanner.nextDouble());
            }
            return reading;
        } catch (Exception e) {
//            e.printStackTrace();
            throw new NullPointerException();
        }
    }

    private void updateListeners(List<Double> newData) {
        for (SensorListener listener : listeners) listener.newReading(newData);
    }

    public void addListener(SensorListener listener) {
        if (listeners.contains(listener)) return;
        listeners.add(listener);
    }

    public void removeListener(SensorListener listener) {
        if (!listeners.contains(listener)) return;
        listeners.remove(listener);
    }

}
