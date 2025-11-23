package com.ide.terminal.command.application;

import com.ide.terminal.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TerminalSessionService {
    
    private TerminalSessionRepository terminalSessionRepository;

    public TerminalSessionService(TerminalSessionRepository terminalSessionRepository) {
        this.terminalSessionRepository = terminalSessionRepository;
    }

    @Transactional
    public TerminalSessionId createSession(String name, String workingDirectory, ShellType shellType) {
        TerminalSessionId id = TerminalSessionId.generate();
        TerminalSession session = new TerminalSession(id, name, workingDirectory, shellType);
        terminalSessionRepository.save(session);
        return id;
    }

    @Transactional
    public void executeCommand(String sessionId, String command) {
        TerminalSession session = terminalSessionRepository.findById(new TerminalSessionId(sessionId))
                .orElseThrow(() -> new NoTerminalSessionException());
        session.executeCommand(command);
    }

    @Transactional
    public void closeSession(String sessionId) {
        TerminalSession session = terminalSessionRepository.findById(new TerminalSessionId(sessionId))
                .orElseThrow(() -> new NoTerminalSessionException());
        session.close();
    }

    @Transactional
    public void changeDirectory(String sessionId, String newDirectory) {
        TerminalSession session = terminalSessionRepository.findById(new TerminalSessionId(sessionId))
                .orElseThrow(() -> new NoTerminalSessionException());
        session.changeDirectory(newDirectory);
    }
}

