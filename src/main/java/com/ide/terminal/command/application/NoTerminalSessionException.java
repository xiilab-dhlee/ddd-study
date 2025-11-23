package com.ide.terminal.command.application;

public class NoTerminalSessionException extends RuntimeException {

    public NoTerminalSessionException() {
        super("Terminal session not found");
    }
}

