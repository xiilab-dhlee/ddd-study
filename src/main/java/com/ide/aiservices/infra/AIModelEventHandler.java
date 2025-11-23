package com.ide.aiservices.infra;

import com.ide.aiservices.command.domain.AIModelActivatedEvent;
import com.ide.aiservices.command.domain.AIModelDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AIModelEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(AIModelEventHandler.class);

    @EventListener
    public void handleModelActivated(AIModelActivatedEvent event) {
        logger.info("AI model activated - ID: {}, Name: {}", 
            event.getModelId().getId(), event.getModelName());
    }

    @EventListener
    public void handleModelDeactivated(AIModelDeactivatedEvent event) {
        logger.info("AI model deactivated - ID: {}, Name: {}", 
            event.getModelId().getId(), event.getModelName());
    }
}

