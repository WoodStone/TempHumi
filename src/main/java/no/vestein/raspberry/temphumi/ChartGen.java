package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.*;

import java.util.LinkedList;
import java.util.List;

public class ChartGen {

    public static String makeChart(LinkedList<List<Double>> data) {
        final double[] humidity = new double[data.size()];
        final double[] temperature = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            temperature[i] = data.get(i).get(0);
            humidity[i] = data.get(i).get(1);
        }

        Line line1 = Plots.newLine(DataUtil.scaleWithinRange(Constants.DATA_RANGE_MIN, Constants.DATA_RANGE_MAX, temperature), Color.newColor("CA3D05"), "Temperature");
        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.DIAMOND, Color.newColor("CA3D05"), 12);
        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 8);
        Line line2 = Plots.newLine(DataUtil.scaleWithinRange(Constants.DATA_RANGE_MIN, Constants.DATA_RANGE_MAX, humidity), Color.SKYBLUE, "Humidity");
        line2.setLineStyle(LineStyle.newLineStyle(2, 1, 0));
        line2.addShapeMarkers(Shape.DIAMOND, Color.SKYBLUE, 10);
        line2.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 6);

        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(Constants.DATA_RANGE_MIN, Constants.DATA_RANGE_MAX);
        yAxis.setAxisStyle(axisStyle);


        LineChart chart = GCharts.newLineChart(line1, line2);
        chart.setSize(Constants.CHART_WIDTH, Constants.CHART_HEIGHT);
        chart.setTitle("Temperature and Humidity", Color.BLACK, 14);

        chart.addYAxisLabels(yAxis);

        chart.setGrid(25, 20, 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(Color.WHITE));

        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.WHITESMOKE, 100);
        chart.setAreaFill(fill);

        return chart.toURLString();
    }

}
