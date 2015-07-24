package no.vestein.raspberry.temphumi;

public final class Constants {
    private Constants() {}

    public static final int DATA_TIME_MAX = 60;
    public static final int DATA_TIME_MIN = 0;
    public static final int DATA_TIME_INTERVAL = 5;
    public static final double DATA_TIME_INTERVAL_MULTIPLIER = 0.5;
    public static final int DATA_YAXIS_INTERVAL = 10;
    public static final int NUM_OF_READINGS = DATA_TIME_MAX + 1;
    public static final int CHART_WIDTH = 1000;
    public static final int CHART_HEIGHT = 300;
    public static final int AUTO_TIME = 60;
    public static final int CMD_TIME = 1;

    public static final String DEV_ARG = "-idea";
    public static final String AUTO_ARG = "-auto";

}
