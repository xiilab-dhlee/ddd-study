package com.ide.projectmanagement.command.application;

import com.ide.projectmanagement.command.domain.Workspace;
import com.ide.projectmanagement.command.domain.WorkspaceId;
import com.ide.projectmanagement.command.domain.WorkspaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkspaceService {

    private WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    @Transactional
    public WorkspaceId createWorkspace(String name, String rootPath) {
        WorkspaceId id = WorkspaceId.generate();
        Workspace workspace = new Workspace(id, name, rootPath);
        workspaceRepository.save(workspace);
        return id;
    }

    @Transactional
    public void addFolder(String workspaceId, String folderPath) {
        Workspace workspace = workspaceRepository.findById(new WorkspaceId(workspaceId))
                .orElseThrow(() -> new NoWorkspaceException());
        workspace.addFolder(folderPath);
    }

    @Transactional
    public void enableGit(String workspaceId, String repositoryUrl) {
        Workspace workspace = workspaceRepository.findById(new WorkspaceId(workspaceId))
                .orElseThrow(() -> new NoWorkspaceException());
        workspace.enableGit(repositoryUrl);
    }
}

