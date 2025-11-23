package com.ide.projectmanagement.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkspaceRepository extends JpaRepository<Workspace, WorkspaceId> {

    Optional<Workspace> findByName(String name);
}

