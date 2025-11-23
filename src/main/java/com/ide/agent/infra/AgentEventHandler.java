package com.ide.agent.infra;

import com.ide.agent.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AgentEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(AgentEventHandler.class);

    @EventListener
    public void handleTaskCreated(AgentTaskCreatedEvent event) {
        logger.info("Agent task created - ID: {}, Type: {}", 
            event.getAgentId().getId(), event.getTaskType());
    }

    @EventListener
    public void handleTaskStarted(AgentTaskStartedEvent event) {
        logger.info("Agent task started - ID: {}", event.getAgentId().getId());
    }

    @EventListener
    public void handleTaskCompleted(AgentTaskCompletedEvent event) {
        logger.info("Agent task completed - ID: {}", event.getAgentId().getId());
    }

    @EventListener
    public void handleTaskFailed(AgentTaskFailedEvent event) {
        logger.error("Agent task failed - ID: {}, Error: {}", 
            event.getAgentId().getId(), event.getErrorMessage());
    }
}

