package com.ide.terminal.command.domain;

import com.ide.common.event.Event;

public class TerminalSessionCreatedEvent extends Event {

    private TerminalSessionId sessionId;
    private String name;

    public TerminalSessionCreatedEvent(TerminalSessionId sessionId, String name) {
        super();
        this.sessionId = sessionId;
        this.name = name;
    }

    public TerminalSessionId getSessionId() {
        return sessionId;
    }

    public String getName() {
        return name;
    }
}

