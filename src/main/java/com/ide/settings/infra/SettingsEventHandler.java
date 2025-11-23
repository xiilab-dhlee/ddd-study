package com.ide.settings.infra;

import com.ide.settings.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SettingsEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(SettingsEventHandler.class);

    @EventListener
    public void handleSettingsCreated(UserSettingsCreatedEvent event) {
        logger.info("User settings created - ID: {}, User ID: {}", 
            event.getSettingsId().getId(), event.getUserId());
    }

    @EventListener
    public void handleSettingsUpdated(SettingsUpdatedEvent event) {
        logger.info("Settings updated - ID: {}, Type: {}", 
            event.getSettingsId().getId(), event.getSettingsType());
    }

    @EventListener
    public void handleSyncEnabled(SettingsSyncEnabledEvent event) {
        logger.info("Settings sync enabled - ID: {}", event.getSettingsId().getId());
    }
}

