package com.ide.agent.command.application;

public class NoAgentTaskException extends RuntimeException {
    
    public NoAgentTaskException() {
        super("Agent task not found");
    }
}

