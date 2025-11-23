package com.ide.terminal.query.application;

import com.ide.terminal.command.domain.TerminalSession;
import com.ide.terminal.command.domain.TerminalSessionId;
import com.ide.terminal.command.domain.TerminalSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TerminalSessionQueryService {
    
    private TerminalSessionRepository terminalSessionRepository;

    public TerminalSessionQueryService(TerminalSessionRepository terminalSessionRepository) {
        this.terminalSessionRepository = terminalSessionRepository;
    }

    public Optional<TerminalSession> getSession(String sessionId) {
        return terminalSessionRepository.findById(new TerminalSessionId(sessionId));
    }

    public List<TerminalSession> getActiveSessions() {
        return terminalSessionRepository.findByIsActive(true);
    }

    public List<TerminalSession> getAllSessions() {
        return terminalSessionRepository.findAll();
    }
}

