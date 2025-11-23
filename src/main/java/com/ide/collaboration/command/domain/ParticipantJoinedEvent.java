package com.ide.collaboration.command.domain;

import com.ide.common.event.Event;

public class ParticipantJoinedEvent extends Event {

    private CollaborationSessionId sessionId;
    private String userId;
    private String userName;

    public ParticipantJoinedEvent(CollaborationSessionId sessionId, String userId, String userName) {
        super();
        this.sessionId = sessionId;
        this.userId = userId;
        this.userName = userName;
    }

    public CollaborationSessionId getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}

