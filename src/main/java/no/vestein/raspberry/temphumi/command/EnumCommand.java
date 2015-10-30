package no.vestein.raspberry.temphumi.command;

import no.vestein.raspberry.temphumi.ChartFile;
import no.vestein.raspberry.temphumi.sensor.SensorTask;

import java.util.List;

public enum EnumCommand {

    GET_GRAPHS("graphs", new GetGraphs()),
    QUIT("quit", new Quit()),
    TO_FILE("tofile", new ToFile());

    private final String legend;
    private final ICommand cClass;

    EnumCommand(String legend, ICommand cClass) {
        this.legend = legend;
        this.cClass = cClass;
    }

    public static void init() {
        CommandHandler handler = CommandHandler.INSTANCE;
        for (EnumCommand command : values()) {
            handler.registerCommand(command.legend, command.cClass);
        }
    }

    private static class ToFile implements ICommand {

        private final ChartFile chartFile = new ChartFile("testfile");

        @Override
        public void processCommand(List<String> strings) {
            String temp = "Temperature=" + SensorTask.data.getTempChart() + "\n";
            String humi = "Humidity=" + SensorTask.data.getHumiChart() + "\n";
            String s = temp + humi;
            chartFile.updateFile(s);
        }
    }

}
