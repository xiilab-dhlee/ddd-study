package com.ide.collaboration.command.application;

public class NoCollaborationSessionException extends RuntimeException {
    
    public NoCollaborationSessionException() {
        super("Collaboration session not found");
    }
}

