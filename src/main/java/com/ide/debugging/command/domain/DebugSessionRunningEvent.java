package com.ide.debugging.command.domain;

import com.myshop.common.event.Event;

public class DebugSessionRunningEvent extends Event {
    
    private DebugSessionId sessionId;

    public DebugSessionRunningEvent(DebugSessionId sessionId) {
        super();
        this.sessionId = sessionId;
    }

    public DebugSessionId getSessionId() {
        return sessionId;
    }
}

