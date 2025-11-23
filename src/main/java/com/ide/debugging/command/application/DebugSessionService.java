package com.ide.debugging.command.application;

import com.ide.debugging.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DebugSessionService {

    private DebugSessionRepository debugSessionRepository;

    public DebugSessionService(DebugSessionRepository debugSessionRepository) {
        this.debugSessionRepository = debugSessionRepository;
    }

    @Transactional
    public DebugSessionId startSession(String programPath) {
        DebugSessionId id = DebugSessionId.generate();
        DebugSession session = new DebugSession(id, programPath);
        debugSessionRepository.save(session);
        return id;
    }

    @Transactional
    public void runSession(String sessionId) {
        DebugSession session = debugSessionRepository.findById(new DebugSessionId(sessionId))
                .orElseThrow(() -> new NoDebugSessionException());
        session.start();
    }

    @Transactional
    public void pauseSession(String sessionId) {
        DebugSession session = debugSessionRepository.findById(new DebugSessionId(sessionId))
                .orElseThrow(() -> new NoDebugSessionException());
        session.pause();
    }

    @Transactional
    public void stopSession(String sessionId) {
        DebugSession session = debugSessionRepository.findById(new DebugSessionId(sessionId))
                .orElseThrow(() -> new NoDebugSessionException());
        session.stop();
    }

    @Transactional
    public void addBreakpoint(String sessionId, String filePath, int lineNumber) {
        DebugSession session = debugSessionRepository.findById(new DebugSessionId(sessionId))
                .orElseThrow(() -> new NoDebugSessionException());
        Breakpoint breakpoint = new Breakpoint(filePath, lineNumber, Breakpoint.BreakpointType.LINE);
        session.addBreakpoint(breakpoint);
    }

    @Transactional
    public void addWatchedVariable(String sessionId, String variableName) {
        DebugSession session = debugSessionRepository.findById(new DebugSessionId(sessionId))
                .orElseThrow(() -> new NoDebugSessionException());
        session.addWatchedVariable(variableName);
    }
}

