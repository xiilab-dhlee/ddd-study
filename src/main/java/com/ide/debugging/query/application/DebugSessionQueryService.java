package com.ide.debugging.query.application;

import com.ide.debugging.command.domain.DebugSession;
import com.ide.debugging.command.domain.DebugSessionId;
import com.ide.debugging.command.domain.DebugSessionRepository;
import com.ide.debugging.command.domain.DebugStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DebugSessionQueryService {
    
    private DebugSessionRepository debugSessionRepository;

    public DebugSessionQueryService(DebugSessionRepository debugSessionRepository) {
        this.debugSessionRepository = debugSessionRepository;
    }

    public Optional<DebugSession> getSession(String sessionId) {
        return debugSessionRepository.findById(new DebugSessionId(sessionId));
    }

    public List<DebugSession> getSessionsByStatus(DebugStatus status) {
        return debugSessionRepository.findByStatus(status);
    }

    public List<DebugSession> getAllSessions() {
        return debugSessionRepository.findAll();
    }
}

