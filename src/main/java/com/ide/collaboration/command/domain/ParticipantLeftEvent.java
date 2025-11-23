package com.ide.collaboration.command.domain;

import com.myshop.common.event.Event;

public class ParticipantLeftEvent extends Event {
    
    private CollaborationSessionId sessionId;
    private String userId;

    public ParticipantLeftEvent(CollaborationSessionId sessionId, String userId) {
        super();
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public CollaborationSessionId getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }
}

