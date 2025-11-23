package com.ide.terminal.command.domain;

import com.ide.common.event.Event;

public class TerminalSessionClosedEvent extends Event {

    private TerminalSessionId sessionId;

    public TerminalSessionClosedEvent(TerminalSessionId sessionId) {
        super();
        this.sessionId = sessionId;
    }

    public TerminalSessionId getSessionId() {
        return sessionId;
    }
}

