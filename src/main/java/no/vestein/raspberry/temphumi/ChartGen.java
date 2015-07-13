package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChartGen {

//    public static String makeChart(ArrayList<LinkedList<Double>> data) {
//        Line line1 = Plots.newLine(DataUtil.scaleWithinRange(Constants.DATA_RANGE_MIN, Constants.DATA_RANGE_MAX, data.get(0)), Color.newColor("CA3D05"), "Temperature");
//        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
//        line1.addShapeMarkers(Shape.DIAMOND, Color.newColor("CA3D05"), 12);
//        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 8);
//        Line line2 = Plots.newLine(DataUtil.scaleWithinRange(Constants.DATA_RANGE_MIN, Constants.DATA_RANGE_MAX, data.get(1)), Color.SKYBLUE, "Humidity");
//        line2.setLineStyle(LineStyle.newLineStyle(2, 1, 0));
//        line2.addShapeMarkers(Shape.DIAMOND, Color.SKYBLUE, 10);
//        line2.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 6);
//
//        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 12, AxisTextAlignment.CENTER);
//        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(Constants.DATA_RANGE_MIN, Constants.DATA_RANGE_MAX);
//        yAxis.setAxisStyle(axisStyle);
//        AxisLabels xAxis = AxisLabelsFactory.newNumericRangeAxisLabels(Constants.DATA_TIME_MIN, Constants.DATA_TIME_MAX, 1);
//        xAxis.setAxisStyle(axisStyle);
//
//
//        LineChart chart = GCharts.newLineChart(line1, line2);
//        chart.setSize(Constants.CHART_WIDTH, Constants.CHART_HEIGHT);
//        chart.setTitle("Temperature and Humidity", Color.BLACK, 14);
//
//        chart.addYAxisLabels(yAxis);
//        chart.addXAxisLabels(xAxis);
//
//        chart.setGrid(10, 12.5, 3, 2);
//        chart.setBackgroundFill(Fills.newSolidFill(Color.WHITE));
//
//        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.WHITESMOKE, 100);
//        chart.setAreaFill(fill);
//
//        return chart.toURLString();
//    }

}
