package com.ide.collaboration.infra;

import com.ide.collaboration.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CollaborationEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(CollaborationEventHandler.class);

    @EventListener
    public void handleSessionCreated(CollaborationSessionCreatedEvent event) {
        logger.info("Collaboration session created - ID: {}, Name: {}, Host: {}", 
            event.getSessionId().getId(), event.getSessionName(), event.getHostUserId());
    }

    @EventListener
    public void handleParticipantJoined(ParticipantJoinedEvent event) {
        logger.info("Participant joined - Session ID: {}, User: {}", 
            event.getSessionId().getId(), event.getUserName());
    }

    @EventListener
    public void handleParticipantLeft(ParticipantLeftEvent event) {
        logger.info("Participant left - Session ID: {}, User ID: {}", 
            event.getSessionId().getId(), event.getUserId());
    }

    @EventListener
    public void handleCollaborativeEdit(CollaborativeEditEvent event) {
        logger.info("Collaborative edit - Session ID: {}, User: {}, Type: {}", 
            event.getSessionId().getId(), event.getUserId(), event.getEditType());
    }

    @EventListener
    public void handleSessionEnded(CollaborationSessionEndedEvent event) {
        logger.info("Collaboration session ended - ID: {}", event.getSessionId().getId());
    }
}

