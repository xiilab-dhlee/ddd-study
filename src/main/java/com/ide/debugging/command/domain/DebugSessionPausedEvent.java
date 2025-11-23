package com.ide.debugging.command.domain;

import com.myshop.common.event.Event;

public class DebugSessionPausedEvent extends Event {
    
    private DebugSessionId sessionId;

    public DebugSessionPausedEvent(DebugSessionId sessionId) {
        super();
        this.sessionId = sessionId;
    }

    public DebugSessionId getSessionId() {
        return sessionId;
    }
}

