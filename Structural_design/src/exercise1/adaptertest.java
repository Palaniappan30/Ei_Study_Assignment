package exercise1;


class OldLogger {
    public void logMessage(String message) {
        System.out.println("Old system logging: " + message);
    }
}

interface NewLogger {
    void log(String message);
}

class LoggerAdapter implements NewLogger {
    private OldLogger oldLogger;

    public LoggerAdapter(OldLogger oldLogger) {
        this.oldLogger = oldLogger;
    }

    @Override
    public void log(String message) {
        oldLogger.logMessage(message);
    }
}

public class adaptertest {
    public static void main(String[] args) {
        OldLogger oldLogger = new OldLogger();
        NewLogger loggerAdapter = new LoggerAdapter(oldLogger);

        loggerAdapter.log("This is a new log message");
    }
}
