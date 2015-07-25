package no.vestein.raspberry.temphumi;

import com.googlecode.charts4j.*;
import static no.vestein.raspberry.temphumi.Constants.*;

import java.util.LinkedList;

public class DataChart {

    private final int rangeMin;
    private final int rangeMax;
    private final double intervalMultiplier;
    private final Color color;
    private final String legend;
    private final LinkedList<Double> data;

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
        line1.setLineStyle(LineStyle.newLineStyle(1, 1, 0));
        line1.addShapeMarkers(Shape.DIAMOND, color, 8);
        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 4);

        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(rangeMin, rangeMax, DATA_YAXIS_INTERVAL);
        yAxis.setAxisStyle(axisStyle);
        AxisLabels xAxis = AxisLabelsFactory.newNumericRangeAxisLabels(DATA_TIME_MIN, DATA_TIME_MAX, DATA_TIME_INTERVAL);
        xAxis.setAxisStyle(axisStyle);

        LineChart chart = GCharts.newLineChart(line1);
        chart.setSize(CHART_WIDTH, CHART_HEIGHT);
        chart.setTitle(legend, Color.BLACK, 14);

        chart.addYAxisLabels(yAxis);
        chart.addXAxisLabels(xAxis);

        chart.setGrid(xAxisStepSize(), yAxisStepSize(), 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(Color.WHITE));

        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.WHITESMOKE, 100);
        chart.setAreaFill(fill);

        return chart.toURLString();

    }

    private double xAxisStepSize() {
        return (1000.0 / ((DATA_TIME_MAX - DATA_TIME_MIN))) * DATA_TIME_INTERVAL_MULTIPLIER;
    }

    private double yAxisStepSize() {
        return (1000.0 / ((rangeMax - rangeMin))) * intervalMultiplier;
    }
}
