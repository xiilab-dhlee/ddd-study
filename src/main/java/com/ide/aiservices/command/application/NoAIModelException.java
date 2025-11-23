package com.ide.aiservices.command.application;

public class NoAIModelException extends RuntimeException {
    
    public NoAIModelException() {
        super("AI model not found");
    }
}

