package no.vestein.raspberry.temphumi.sensor;

import com.googlecode.charts4j.Color;
import no.vestein.raspberry.temphumi.DataChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class SensorData implements SensorListener {

    private final int listLength;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final LinkedList<Double> tempData = new LinkedList<>();
    private final LinkedList<Double> humiData = new LinkedList<>();
    private final DataChart tempChart = new DataChart(0, 40, 0.5, Color.RED, "Temperature", tempData);
    private final DataChart humiChart = new DataChart(20, 80, 1, Color.SKYBLUE, "Humidity", humiData);

    public SensorData(int listLength) {
        this.listLength = listLength;
    }

    public ArrayList<LinkedList<Double>> getData() {
        lock.readLock().lock();
        try {
            ArrayList<LinkedList<Double>> data = new ArrayList<>();
            data.add(tempData);
            data.add(humiData);
            return data;
        } finally {
            lock.readLock().unlock();
        }
    }

    public LinkedList<Double> getTempData() {
        lock.readLock().lock();
        try {
            return tempData;
        } finally {
            lock.readLock().unlock();
        }
    }

    public LinkedList<Double> getHumiData() {
        lock.readLock().lock();
        try {
            return humiData;
        } finally {
            lock.readLock().unlock();
        }
    }

    public String getTempChart() {
        lock.readLock().lock();
        try {
            return tempChart.chart();
        } finally {
            lock.readLock().unlock();
        }
    }

    public String getHumiChart() {
        lock.readLock().lock();
        try {
            return humiChart.chart();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void newReading(List<Double> newReading) {
        lock.writeLock().lock();
        try {
            if (tempData.size() == listLength) {
                tempData.removeFirst();
                humiData.removeFirst();
                tempData.addLast(newReading.get(0));
                humiData.addLast(newReading.get(1));
            } else {
                tempData.add(newReading.get(0));
                humiData.add(newReading.get(1));
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
}
