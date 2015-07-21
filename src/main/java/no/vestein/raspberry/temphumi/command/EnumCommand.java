package no.vestein.raspberry.temphumi.command;

public enum EnumCommand {

    NEW_READING("read", new NewReading()),
    QUIT("quit", new Quit());

    private final String legend;
    private final ICommand cClass;

    EnumCommand(String legend, ICommand cClass) {
        this.legend = legend;
        this.cClass = cClass;
    }

    public static void init() {
        CommandHandler handler = CommandHandler.getInstance();
        for (EnumCommand command : values()) {
            handler.registerCommand(command.legend, command.cClass);
        }
    }

}
