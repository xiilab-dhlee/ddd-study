package com.ide.debugging.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebugSessionRepository extends JpaRepository<DebugSession, DebugSessionId> {
    
    List<DebugSession> findByStatus(DebugStatus status);
}

