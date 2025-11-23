package com.ide.extensions.infra;

import com.ide.extensions.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ExtensionEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(ExtensionEventHandler.class);

    @EventListener
    public void handleExtensionInstalled(ExtensionInstalledEvent event) {
        logger.info("Extension installed - ID: {}, Name: {}, Version: {}", 
            event.getExtensionId().getId(), event.getName(), event.getVersion());
    }

    @EventListener
    public void handleExtensionUninstalled(ExtensionUninstalledEvent event) {
        logger.info("Extension uninstalled - ID: {}, Name: {}", 
            event.getExtensionId().getId(), event.getName());
    }

    @EventListener
    public void handleExtensionEnabled(ExtensionEnabledEvent event) {
        logger.info("Extension enabled - ID: {}, Name: {}", 
            event.getExtensionId().getId(), event.getName());
    }

    @EventListener
    public void handleExtensionDisabled(ExtensionDisabledEvent event) {
        logger.info("Extension disabled - ID: {}, Name: {}", 
            event.getExtensionId().getId(), event.getName());
    }
}

