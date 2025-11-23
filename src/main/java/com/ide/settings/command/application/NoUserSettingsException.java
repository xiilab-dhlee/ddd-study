package com.ide.settings.command.application;

public class NoUserSettingsException extends RuntimeException {

    public NoUserSettingsException() {
        super("User settings not found");
    }
}

