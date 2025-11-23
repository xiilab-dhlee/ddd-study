package com.ide.languageintelligence.infra;

import com.ide.languageintelligence.command.domain.CompletionSelectedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CompletionEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(CompletionEventHandler.class);

    @EventListener
    public void handleCompletionSelected(CompletionSelectedEvent event) {
        logger.info("Completion selected - ID: {}, Item: {}", 
            event.getCompletionId().getId(), 
            event.getSelectedItem().getLabel());
    }
}

