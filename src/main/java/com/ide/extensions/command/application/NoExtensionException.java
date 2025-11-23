package com.ide.extensions.command.application;

public class NoExtensionException extends RuntimeException {
    
    public NoExtensionException() {
        super("Extension not found");
    }
}

