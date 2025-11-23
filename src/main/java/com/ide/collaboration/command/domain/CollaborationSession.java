package com.ide.collaboration.command.domain;

import com.ide.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "collaboration_session")
public class CollaborationSession {

    @EmbeddedId
    private CollaborationSessionId id;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "host_user_id")
    private String hostUserId;

    @ElementCollection
    @CollectionTable(name = "collaboration_participants", 
                    joinColumns = @JoinColumn(name = "session_id"))
    private List<Participant> participants;

    @Column(name = "shared_file_path")
    private String sharedFilePath;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "max_participants")
    private int maxParticipants;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    protected CollaborationSession() {
    }

    public CollaborationSession(CollaborationSessionId id, String sessionName, 
                               String hostUserId, String sharedFilePath) {
        this.id = id;
        this.sessionName = sessionName;
        this.hostUserId = hostUserId;
        this.sharedFilePath = sharedFilePath;
        this.participants = new ArrayList<>();
        this.isActive = true;
        this.maxParticipants = 10;
        this.createdAt = LocalDateTime.now();

        this.participants.add(new Participant(hostUserId, "Host", Participant.ParticipantRole.OWNER));

        Events.raise(new CollaborationSessionCreatedEvent(id, sessionName, hostUserId));
    }

    public void addParticipant(String userId, String userName, Participant.ParticipantRole role) {
        if (!isActive) {
            throw new IllegalStateException("Collaboration session is not active");
        }
        if (participants.size() >= maxParticipants) {
            throw new IllegalStateException("Maximum participants reached");
        }

        Participant participant = new Participant(userId, userName, role);
        participants.add(participant);
        Events.raise(new ParticipantJoinedEvent(id, userId, userName));
    }

    public void removeParticipant(String userId) {
        participants.removeIf(p -> p.getUserId().equals(userId));
        Events.raise(new ParticipantLeftEvent(id, userId));
    }

    public void shareEdit(String userId, String editType, int position, String content) {
        if (!isActive) {
            throw new IllegalStateException("Session is not active");
        }
        Events.raise(new CollaborativeEditEvent(id, userId, editType, position, content));
    }

    public void endSession() {
        this.isActive = false;
        this.endedAt = LocalDateTime.now();
        Events.raise(new CollaborationSessionEndedEvent(id));
    }

    public CollaborationSessionId getId() {
        return id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getHostUserId() {
        return hostUserId;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public String getSharedFilePath() {
        return sharedFilePath;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

