package com.ide.debugging.command.domain;

import com.ide.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "debug_session")
public class DebugSession {

    @EmbeddedId
    private DebugSessionId id;

    @Column(name = "program_path")
    private String programPath;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DebugStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    private List<Breakpoint> breakpoints;

    @ElementCollection
    @CollectionTable(name = "watched_variables", 
                    joinColumns = @JoinColumn(name = "session_id"))
    @Column(name = "variable_name")
    private List<String> watchedVariables;

    @Column(name = "current_line")
    private Integer currentLine;

    @Column(name = "current_file")
    private String currentFile;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    protected DebugSession() {
    }

    public DebugSession(DebugSessionId id, String programPath) {
        this.id = id;
        this.programPath = programPath;
        this.status = DebugStatus.INITIALIZED;
        this.breakpoints = new ArrayList<>();
        this.watchedVariables = new ArrayList<>();
        this.startedAt = LocalDateTime.now();

        Events.raise(new DebugSessionStartedEvent(id, programPath));
    }

    public void start() {
        if (this.status != DebugStatus.INITIALIZED && this.status != DebugStatus.PAUSED) {
            throw new IllegalStateException("Cannot start debug session");
        }
        this.status = DebugStatus.RUNNING;
        Events.raise(new DebugSessionRunningEvent(id));
    }

    public void pause() {
        if (this.status != DebugStatus.RUNNING) {
            throw new IllegalStateException("Debug session not running");
        }
        this.status = DebugStatus.PAUSED;
        Events.raise(new DebugSessionPausedEvent(id));
    }

    public void stop() {
        this.status = DebugStatus.STOPPED;
        this.endedAt = LocalDateTime.now();
        Events.raise(new DebugSessionStoppedEvent(id));
    }

    public void addBreakpoint(Breakpoint breakpoint) {
        this.breakpoints.add(breakpoint);
    }

    public void removeBreakpoint(Long breakpointId) {
        this.breakpoints.removeIf(bp -> bp.getId().equals(breakpointId));
    }

    public void addWatchedVariable(String variableName) {
        if (!this.watchedVariables.contains(variableName)) {
            this.watchedVariables.add(variableName);
        }
    }

    public void stepOver() {
        if (this.status != DebugStatus.PAUSED) {
            throw new IllegalStateException("Must be paused to step over");
        }
        Events.raise(new DebugStepEvent(id, "stepOver"));
    }

    public void stepInto() {
        if (this.status != DebugStatus.PAUSED) {
            throw new IllegalStateException("Must be paused to step into");
        }
        Events.raise(new DebugStepEvent(id, "stepInto"));
    }

    public void stepOut() {
        if (this.status != DebugStatus.PAUSED) {
            throw new IllegalStateException("Must be paused to step out");
        }
        Events.raise(new DebugStepEvent(id, "stepOut"));
    }

    public DebugSessionId getId() {
        return id;
    }

    public String getProgramPath() {
        return programPath;
    }

    public DebugStatus getStatus() {
        return status;
    }

    public List<Breakpoint> getBreakpoints() {
        return breakpoints;
    }

    public List<String> getWatchedVariables() {
        return watchedVariables;
    }

    public Integer getCurrentLine() {
        return currentLine;
    }

    public String getCurrentFile() {
        return currentFile;
    }
}

