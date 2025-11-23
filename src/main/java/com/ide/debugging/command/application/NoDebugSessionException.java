package com.ide.debugging.command.application;

public class NoDebugSessionException extends RuntimeException {
    
    public NoDebugSessionException() {
        super("Debug session not found");
    }
}

