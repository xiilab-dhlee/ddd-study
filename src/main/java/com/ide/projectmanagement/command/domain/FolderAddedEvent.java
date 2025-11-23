package com.ide.projectmanagement.command.domain;

import com.ide.common.event.Event;

public class FolderAddedEvent extends Event {
    
    private WorkspaceId workspaceId;
    private String folderPath;

    public FolderAddedEvent(WorkspaceId workspaceId, String folderPath) {
        super();
        this.workspaceId = workspaceId;
        this.folderPath = folderPath;
    }

    public WorkspaceId getWorkspaceId() {
        return workspaceId;
    }

    public String getFolderPath() {
        return folderPath;
    }
}

