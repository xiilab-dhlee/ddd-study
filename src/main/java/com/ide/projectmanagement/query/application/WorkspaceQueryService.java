package com.ide.projectmanagement.query.application;

import com.ide.projectmanagement.command.domain.Workspace;
import com.ide.projectmanagement.command.domain.WorkspaceId;
import com.ide.projectmanagement.command.domain.WorkspaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class WorkspaceQueryService {
    
    private WorkspaceRepository workspaceRepository;

    public WorkspaceQueryService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public Optional<Workspace> getWorkspace(String workspaceId) {
        return workspaceRepository.findById(new WorkspaceId(workspaceId));
    }

    public Optional<Workspace> getWorkspaceByName(String name) {
        return workspaceRepository.findByName(name);
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }
}

