package com.kodilla.patterns.singleton;

public class Logger {
    private String lastlog = "";
    private static Logger loggerInstance = null;

    private Logger() {
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void log(String log) {
        this.lastlog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastlog;
    }
}
