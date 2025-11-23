package com.ide.projectmanagement.command.domain;

import com.myshop.common.event.Event;

public class GitEnabledEvent extends Event {
    
    private WorkspaceId workspaceId;
    private String repositoryUrl;

    public GitEnabledEvent(WorkspaceId workspaceId, String repositoryUrl) {
        super();
        this.workspaceId = workspaceId;
        this.repositoryUrl = repositoryUrl;
    }

    public WorkspaceId getWorkspaceId() {
        return workspaceId;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }
}

