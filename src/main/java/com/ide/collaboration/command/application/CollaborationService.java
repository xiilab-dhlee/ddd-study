package com.ide.collaboration.command.application;

import com.ide.collaboration.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CollaborationService {
    
    private CollaborationSessionRepository collaborationSessionRepository;

    public CollaborationService(CollaborationSessionRepository collaborationSessionRepository) {
        this.collaborationSessionRepository = collaborationSessionRepository;
    }

    @Transactional
    public CollaborationSessionId createSession(String sessionName, String hostUserId, 
                                               String sharedFilePath) {
        CollaborationSessionId id = CollaborationSessionId.generate();
        CollaborationSession session = new CollaborationSession(id, sessionName, 
                                                               hostUserId, sharedFilePath);
        collaborationSessionRepository.save(session);
        return id;
    }

    @Transactional
    public void joinSession(String sessionId, String userId, String userName, 
                          Participant.ParticipantRole role) {
        CollaborationSession session = collaborationSessionRepository
                .findById(new CollaborationSessionId(sessionId))
                .orElseThrow(() -> new NoCollaborationSessionException());
        session.addParticipant(userId, userName, role);
    }

    @Transactional
    public void leaveSession(String sessionId, String userId) {
        CollaborationSession session = collaborationSessionRepository
                .findById(new CollaborationSessionId(sessionId))
                .orElseThrow(() -> new NoCollaborationSessionException());
        session.removeParticipant(userId);
    }

    @Transactional
    public void shareEdit(String sessionId, String userId, String editType, 
                        int position, String content) {
        CollaborationSession session = collaborationSessionRepository
                .findById(new CollaborationSessionId(sessionId))
                .orElseThrow(() -> new NoCollaborationSessionException());
        session.shareEdit(userId, editType, position, content);
    }

    @Transactional
    public void endSession(String sessionId) {
        CollaborationSession session = collaborationSessionRepository
                .findById(new CollaborationSessionId(sessionId))
                .orElseThrow(() -> new NoCollaborationSessionException());
        session.endSession();
    }
}

