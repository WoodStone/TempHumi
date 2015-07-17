package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.*;

import java.util.LinkedList;

public class DataChart {

    private final int rangeMin;
    private final int rangeMax;
    private final double intervalMultiplier;
    private final Color color;
    private final String legend;
    private LinkedList<Double> data;

    public DataChart(int rangeMin, int rangeMax, double intervalMultiplier, Color color, String legend, LinkedList<Double> data) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.intervalMultiplier = intervalMultiplier;
        this.color = color;
        this.legend = legend;
        this.data = data;
    }

    public String chart() {
        Line line1 = Plots.newLine(DataUtil.scaleWithinRange(rangeMin, rangeMax, data), color);
        line1.setLineStyle(LineStyle.newLineStyle(2, 1, 0));
        line1.addShapeMarkers(Shape.DIAMOND, color, 10);
        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 6);

        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(rangeMin, rangeMax, Constants.DATA_YAXIS_INTERVAL);
        yAxis.setAxisStyle(axisStyle);
        AxisLabels xAxis = AxisLabelsFactory.newNumericRangeAxisLabels(Constants.DATA_TIME_MIN, Constants.DATA_TIME_MAX, Constants.DATA_TIME_INTERVAL);
        xAxis.setAxisStyle(axisStyle);

        LineChart chart = GCharts.newLineChart(line1);
        chart.setSize(Constants.CHART_WIDTH, Constants.CHART_HEIGHT);
        chart.setTitle(legend, Color.BLACK, 14);

        chart.addYAxisLabels(yAxis);
        chart.addXAxisLabels(xAxis);

        chart.setGrid(10, yAxisStepSize(), 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(Color.WHITE));

        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.WHITESMOKE, 100);
        chart.setAreaFill(fill);

        return chart.toURLString();

    }

    private double yAxisStepSize() {
        return (1000.0 / ((rangeMax - rangeMin))) * intervalMultiplier;
    }
}