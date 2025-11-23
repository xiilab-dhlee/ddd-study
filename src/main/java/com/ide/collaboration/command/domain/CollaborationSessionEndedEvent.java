package com.ide.collaboration.command.domain;

import com.ide.common.event.Event;

public class CollaborationSessionEndedEvent extends Event {

    private CollaborationSessionId sessionId;

    public CollaborationSessionEndedEvent(CollaborationSessionId sessionId) {
        super();
        this.sessionId = sessionId;
    }

    public CollaborationSessionId getSessionId() {
        return sessionId;
    }
}

