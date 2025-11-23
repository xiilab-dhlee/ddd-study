package com.ide.projectmanagement.command.domain;

import com.myshop.common.event.Event;

public class WorkspaceCreatedEvent extends Event {
    
    private WorkspaceId workspaceId;
    private String name;
    private String rootPath;

    public WorkspaceCreatedEvent(WorkspaceId workspaceId, String name, String rootPath) {
        super();
        this.workspaceId = workspaceId;
        this.name = name;
        this.rootPath = rootPath;
    }

    public WorkspaceId getWorkspaceId() {
        return workspaceId;
    }

    public String getName() {
        return name;
    }

    public String getRootPath() {
        return rootPath;
    }
}

