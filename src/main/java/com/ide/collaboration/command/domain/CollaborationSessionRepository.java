package com.ide.collaboration.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaborationSessionRepository extends JpaRepository<CollaborationSession, CollaborationSessionId> {

    List<CollaborationSession> findByHostUserId(String hostUserId);

    List<CollaborationSession> findByIsActive(boolean isActive);
}

