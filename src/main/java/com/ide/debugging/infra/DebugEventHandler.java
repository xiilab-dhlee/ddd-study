package com.ide.debugging.infra;

import com.ide.debugging.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DebugEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(DebugEventHandler.class);

    @EventListener
    public void handleSessionStarted(DebugSessionStartedEvent event) {
        logger.info("Debug session started - ID: {}, Program: {}", 
            event.getSessionId().getId(), event.getProgramPath());
    }

    @EventListener
    public void handleSessionRunning(DebugSessionRunningEvent event) {
        logger.info("Debug session running - ID: {}", event.getSessionId().getId());
    }

    @EventListener
    public void handleSessionPaused(DebugSessionPausedEvent event) {
        logger.info("Debug session paused - ID: {}", event.getSessionId().getId());
    }

    @EventListener
    public void handleSessionStopped(DebugSessionStoppedEvent event) {
        logger.info("Debug session stopped - ID: {}", event.getSessionId().getId());
    }

    @EventListener
    public void handleDebugStep(DebugStepEvent event) {
        logger.info("Debug step - ID: {}, Type: {}", 
            event.getSessionId().getId(), event.getStepType());
    }
}

