package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static LinkedList<List<Double>> data = new LinkedList<>();

    public static void main(String[] args) {
        Sensor sensor = new Sensor(11, 4);
        SensorData data = new SensorData(10);

        sensor.addListener(data);

        while (true) {
            sensor.update();

            System.out.println(ChartGen.makeChart(data.getData()));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }


        }

//        System.out.println(example1());

//        update();
//        System.out.println(data);

    }



    public static String example1() {

        // Defining lines
        final int NUM_POINTS = 50;
        final double[] humidity = new double[NUM_POINTS];
        final double[] temperature = new double[NUM_POINTS];
        for (int i = 0; i < NUM_POINTS; i++) {
            humidity[i] = 100 - (Math.cos(30 * i * Math.PI / 180) * 10 + 50) * i / 20;
            temperature[i] = (Math.cos(30 * i * Math.PI / 180) * 10 + 50) * i / 20;
        }
//        Line line1 = Plots.newLine(Data.newData(temperature), Color.newColor("CA3D05"), "Temperature");
        Line line1 = Plots.newLine(DataUtil.scaleWithinRange(0, 100, temperature), Color.YELLOW, "Temperature");
        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.DIAMOND, Color.newColor("CA3D05"), 12);
        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 8);
        Line line2 = Plots.newLine(Data.newData(humidity), Color.SKYBLUE, "Humidity");
//        line2.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line2.addShapeMarkers(Shape.DIAMOND, Color.SKYBLUE, 10);
        line2.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 6);


        // Defining chart.
        LineChart chart = GCharts.newLineChart(line1, line2);
        chart.setSize(1000, 300);
        chart.setTitle("Temperature and Humidity", Color.BLACK, 14);
//        chart.addHorizontalRangeMarker(40, 60, Color.newColor(Color.RED, 30));
//        chart.addVerticalRangeMarker(70, 90, Color.newColor(Color.GREEN, 30));
        chart.setGrid(25, 25, 3, 2);

//        // Defining axis info and styles
//        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.WHITE, 12, AxisTextAlignment.CENTER);
//        AxisLabels xAxis = AxisLabelsFactory.newAxisLabels("Nov", "Dec", "Jan", "Feb", "Mar");
//        xAxis.setAxisStyle(axisStyle);
//        AxisLabels xAxis2 = AxisLabelsFactory.newAxisLabels("2007", "2007", "2008", "2008", "2008");
//        xAxis2.setAxisStyle(axisStyle);
//        AxisLabels yAxis = AxisLabelsFactory.newAxisLabels("", "25", "50", "75", "100");
//        AxisLabels xAxis3 = AxisLabelsFactory.newAxisLabels("Month", 50.0);
//        xAxis3.setAxisStyle(AxisStyle.newAxisStyle(Color.WHITE, 14, AxisTextAlignment.CENTER));
//        yAxis.setAxisStyle(axisStyle);
//        AxisLabels yAxis2 = AxisLabelsFactory.newAxisLabels("Hits", 50.0);
//        yAxis2.setAxisStyle(AxisStyle.newAxisStyle(Color.WHITE, 14, AxisTextAlignment.CENTER));
//        yAxis2.setAxisStyle(axisStyle);
//
//        // Adding axis info to chart.
//        chart.addXAxisLabels(xAxis);
//        chart.addXAxisLabels(xAxis2);
//        chart.addXAxisLabels(xAxis3);
//        chart.addYAxisLabels(yAxis);
//        chart.addYAxisLabels(yAxis2);

        // Defining background and chart fills.
//        chart.setBackgroundFill(Fills.newSolidFill(Color.newColor("1F1D1D")));
        chart.setBackgroundFill(Fills.newSolidFill(Color.WHITE));
//        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.newColor("363433"), 100);
        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.WHITESMOKE, 100);
//        fill.addColorAndOffset(Color.newColor("2E2B2A"), 0);
//        fill.addColorAndOffset(Color.WHITESMOKE, 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        return url;
    }

}
