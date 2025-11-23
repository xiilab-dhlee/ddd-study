package com.ide.collaboration.query.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CollaborationSessionDTO {
    
    private String collaborationSessionId;
    private String sessionName;
    private String hostUserId;
    private String sharedFilePath;
    private boolean isActive;
    private int participantCount;
    private LocalDateTime createdAt;

    public CollaborationSessionDTO(String collaborationSessionId, String sessionName, String hostUserId,
                                  String sharedFilePath, boolean isActive, int participantCount,
                                  LocalDateTime createdAt) {
        this.collaborationSessionId = collaborationSessionId;
        this.sessionName = sessionName;
        this.hostUserId = hostUserId;
        this.sharedFilePath = sharedFilePath;
        this.isActive = isActive;
        this.participantCount = participantCount;
        this.createdAt = createdAt;
    }

    public String getCollaborationSessionId() {
        return collaborationSessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getHostUserId() {
        return hostUserId;
    }

    public String getSharedFilePath() {
        return sharedFilePath;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

