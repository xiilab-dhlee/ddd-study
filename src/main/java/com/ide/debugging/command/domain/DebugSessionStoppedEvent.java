package com.ide.debugging.command.domain;

import com.myshop.common.event.Event;

public class DebugSessionStoppedEvent extends Event {
    
    private DebugSessionId sessionId;

    public DebugSessionStoppedEvent(DebugSessionId sessionId) {
        super();
        this.sessionId = sessionId;
    }

    public DebugSessionId getSessionId() {
        return sessionId;
    }
}

