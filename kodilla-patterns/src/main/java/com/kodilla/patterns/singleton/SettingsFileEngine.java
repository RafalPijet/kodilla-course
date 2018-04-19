package com.kodilla.patterns.singleton;

public class SettingsFileEngine {
    private String filname = "";
    private static SettingsFileEngine settingsFileEngineInstance = null;

    private SettingsFileEngine() {

    }

    public static SettingsFileEngine getInstance() {
        if (settingsFileEngineInstance == null) {
            settingsFileEngineInstance = new SettingsFileEngine();
        }
        return settingsFileEngineInstance;
    }

    public String getFilname() {
        return filname;
    }

    public void open(final String filname) {
        this.filname = filname;
        System.out.println("Opening the settings file");
    }

    public void close() {
        this.filname = "";
        System.out.println("Closing the settings file");
    }

    public boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }

    public boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }
}
