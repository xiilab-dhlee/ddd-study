package com.ide.debugging.command.domain;

import com.ide.common.event.Event;

public class DebugStepEvent extends Event {
    
    private DebugSessionId sessionId;
    private String stepType;

    public DebugStepEvent(DebugSessionId sessionId, String stepType) {
        super();
        this.sessionId = sessionId;
        this.stepType = stepType;
    }

    public DebugSessionId getSessionId() {
        return sessionId;
    }

    public String getStepType() {
        return stepType;
    }
}

