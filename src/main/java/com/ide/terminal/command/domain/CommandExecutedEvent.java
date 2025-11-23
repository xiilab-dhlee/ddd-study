package com.ide.terminal.command.domain;

import com.ide.common.event.Event;

public class CommandExecutedEvent extends Event {

    private TerminalSessionId sessionId;
    private String command;

    public CommandExecutedEvent(TerminalSessionId sessionId, String command) {
        super();
        this.sessionId = sessionId;
        this.command = command;
    }

    public TerminalSessionId getSessionId() {
        return sessionId;
    }

    public String getCommand() {
        return command;
    }
}

