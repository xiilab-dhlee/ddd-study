package com.ide.projectmanagement.query.dto;

import java.time.LocalDateTime;
import java.util.List;

public class WorkspaceDTO {
    
    private String workspaceId;
    private String name;
    private String rootPath;
    private List<String> folders;
    private boolean gitEnabled;
    private String gitRepositoryUrl;
    private LocalDateTime lastOpenedAt;

    public WorkspaceDTO(String workspaceId, String name, String rootPath, List<String> folders,
                       boolean gitEnabled, String gitRepositoryUrl, LocalDateTime lastOpenedAt) {
        this.workspaceId = workspaceId;
        this.name = name;
        this.rootPath = rootPath;
        this.folders = folders;
        this.gitEnabled = gitEnabled;
        this.gitRepositoryUrl = gitRepositoryUrl;
        this.lastOpenedAt = lastOpenedAt;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    public String getName() {
        return name;
    }

    public String getRootPath() {
        return rootPath;
    }

    public List<String> getFolders() {
        return folders;
    }

    public boolean isGitEnabled() {
        return gitEnabled;
    }

    public String getGitRepositoryUrl() {
        return gitRepositoryUrl;
    }

    public LocalDateTime getLastOpenedAt() {
        return lastOpenedAt;
    }
}

