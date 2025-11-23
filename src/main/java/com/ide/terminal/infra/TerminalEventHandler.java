package com.ide.terminal.infra;

import com.ide.terminal.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TerminalEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(TerminalEventHandler.class);

    @EventListener
    public void handleSessionCreated(TerminalSessionCreatedEvent event) {
        logger.info("Terminal session created - ID: {}, Name: {}", 
            event.getSessionId().getId(), event.getName());
    }

    @EventListener
    public void handleCommandExecuted(CommandExecutedEvent event) {
        logger.info("Command executed - Session ID: {}, Command: {}", 
            event.getSessionId().getId(), event.getCommand());
    }

    @EventListener
    public void handleSessionClosed(TerminalSessionClosedEvent event) {
        logger.info("Terminal session closed - ID: {}", event.getSessionId().getId());
    }
}

