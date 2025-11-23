package com.ide.projectmanagement.command.domain;

import com.ide.common.event.Event;

public class FolderRemovedEvent extends Event {

    private WorkspaceId workspaceId;
    private String folderPath;

    public FolderRemovedEvent(WorkspaceId workspaceId, String folderPath) {
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

