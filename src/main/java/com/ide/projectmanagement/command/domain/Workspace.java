package com.ide.projectmanagement.command.domain;

import com.ide.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workspace")
public class Workspace {
    
    @EmbeddedId
    private WorkspaceId id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "root_path")
    private String rootPath;
    
    @ElementCollection
    @CollectionTable(name = "workspace_folders", 
                    joinColumns = @JoinColumn(name = "workspace_id"))
    @Column(name = "folder_path")
    private List<String> folders;
    
    @Column(name = "git_enabled")
    private boolean gitEnabled;
    
    @Column(name = "git_repository_url")
    private String gitRepositoryUrl;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "last_opened_at")
    private LocalDateTime lastOpenedAt;

    protected Workspace() {
    }

    public Workspace(WorkspaceId id, String name, String rootPath) {
        this.id = id;
        this.name = name;
        this.rootPath = rootPath;
        this.folders = new ArrayList<>();
        this.gitEnabled = false;
        this.createdAt = LocalDateTime.now();
        this.lastOpenedAt = LocalDateTime.now();
        
        Events.raise(new WorkspaceCreatedEvent(id, name, rootPath));
    }

    public void addFolder(String folderPath) {
        if (!folders.contains(folderPath)) {
            folders.add(folderPath);
            Events.raise(new FolderAddedEvent(id, folderPath));
        }
    }

    public void removeFolder(String folderPath) {
        if (folders.remove(folderPath)) {
            Events.raise(new FolderRemovedEvent(id, folderPath));
        }
    }

    public void enableGit(String repositoryUrl) {
        this.gitEnabled = true;
        this.gitRepositoryUrl = repositoryUrl;
        Events.raise(new GitEnabledEvent(id, repositoryUrl));
    }

    public void updateLastOpened() {
        this.lastOpenedAt = LocalDateTime.now();
    }

    // Getters
    public WorkspaceId getId() {
        return id;
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

