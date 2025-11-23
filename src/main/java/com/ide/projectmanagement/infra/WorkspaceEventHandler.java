package com.ide.projectmanagement.infra;

import com.ide.projectmanagement.command.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceEventHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(WorkspaceEventHandler.class);

    @EventListener
    public void handleWorkspaceCreated(WorkspaceCreatedEvent event) {
        logger.info("Workspace created - ID: {}, Name: {}", 
            event.getWorkspaceId().getId(), event.getName());
    }

    @EventListener
    public void handleFolderAdded(FolderAddedEvent event) {
        logger.info("Folder added - Workspace ID: {}, Path: {}", 
            event.getWorkspaceId().getId(), event.getFolderPath());
    }

    @EventListener
    public void handleFolderRemoved(FolderRemovedEvent event) {
        logger.info("Folder removed - Workspace ID: {}, Path: {}", 
            event.getWorkspaceId().getId(), event.getFolderPath());
    }

    @EventListener
    public void handleGitEnabled(GitEnabledEvent event) {
        logger.info("Git enabled - Workspace ID: {}, Repo URL: {}", 
            event.getWorkspaceId().getId(), event.getRepositoryUrl());
    }
}

