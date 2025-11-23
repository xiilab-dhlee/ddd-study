package com.ide.collaboration.command.domain;

import com.ide.common.event.Event;

public class CollaborativeEditEvent extends Event {
    
    private CollaborationSessionId sessionId;
    private String userId;
    private String editType;
    private int position;
    private String content;

    public CollaborativeEditEvent(CollaborationSessionId sessionId, String userId, 
                                 String editType, int position, String content) {
        super();
        this.sessionId = sessionId;
        this.userId = userId;
        this.editType = editType;
        this.position = position;
        this.content = content;
    }

    public CollaborationSessionId getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getEditType() {
        return editType;
    }

    public int getPosition() {
        return position;
    }

    public String getContent() {
        return content;
    }
}

