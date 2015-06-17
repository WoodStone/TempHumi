package no.vestein.raspberry.temphumi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sensor {

    private ArrayList<SensorListener> listeners = new ArrayList<>();
    private int type;
    private int pin;

    public Sensor(int type, int pin) {
        setPin(pin);
        setType(type);
    }

    public void update() {
        try {
            updateListeners(newReading());
        } catch (NullPointerException e) {

        }
    }

    public List<Double> newReading() {
//        String cmd = "sudo python DHT.py 11 4";
        String cmd = "sudo python DHT.py" + type + pin;
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

    public void setPin(int pin) {
        if (pin != 4) throw new IllegalArgumentException();
        this.pin = pin;
    }

    public void setType(int type) {
        if (type != 11) throw new IllegalArgumentException();
        this.type = type;
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
