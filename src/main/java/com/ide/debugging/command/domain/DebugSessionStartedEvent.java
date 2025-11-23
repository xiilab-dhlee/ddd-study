package com.ide.debugging.command.domain;

import com.ide.common.event.Event;

public class DebugSessionStartedEvent extends Event {

    private DebugSessionId sessionId;
    private String programPath;

    public DebugSessionStartedEvent(DebugSessionId sessionId, String programPath) {
        super();
        this.sessionId = sessionId;
        this.programPath = programPath;
    }

    public DebugSessionId getSessionId() {
        return sessionId;
    }

    public String getProgramPath() {
        return programPath;
    }
}

