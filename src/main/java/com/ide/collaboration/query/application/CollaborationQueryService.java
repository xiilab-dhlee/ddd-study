package com.ide.collaboration.query.application;

import com.ide.collaboration.command.domain.CollaborationSession;
import com.ide.collaboration.command.domain.CollaborationSessionId;
import com.ide.collaboration.command.domain.CollaborationSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CollaborationQueryService {
    
    private CollaborationSessionRepository collaborationSessionRepository;

    public CollaborationQueryService(CollaborationSessionRepository collaborationSessionRepository) {
        this.collaborationSessionRepository = collaborationSessionRepository;
    }

    public Optional<CollaborationSession> getSession(String sessionId) {
        return collaborationSessionRepository.findById(new CollaborationSessionId(sessionId));
    }

    public List<CollaborationSession> getSessionsByHost(String hostUserId) {
        return collaborationSessionRepository.findByHostUserId(hostUserId);
    }

    public List<CollaborationSession> getActiveSessions() {
        return collaborationSessionRepository.findByIsActive(true);
    }

    public List<CollaborationSession> getAllSessions() {
        return collaborationSessionRepository.findAll();
    }
}

