package com.ide.collaboration.command.domain;

import com.myshop.common.event.Event;

public class CollaborationSessionCreatedEvent extends Event {
    
    private CollaborationSessionId sessionId;
    private String sessionName;
    private String hostUserId;

    public CollaborationSessionCreatedEvent(CollaborationSessionId sessionId, 
                                          String sessionName, String hostUserId) {
        super();
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.hostUserId = hostUserId;
    }

    public CollaborationSessionId getSessionId() {
        return sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getHostUserId() {
        return hostUserId;
    }
}

