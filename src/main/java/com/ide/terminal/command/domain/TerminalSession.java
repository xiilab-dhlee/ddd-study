package com.ide.terminal.command.domain;

import com.ide.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "terminal_session")
public class TerminalSession {

    @EmbeddedId
    private TerminalSessionId id;

    @Column(name = "name")
    private String name;

    @Column(name = "working_directory")
    private String workingDirectory;

    @Enumerated(EnumType.STRING)
    @Column(name = "shell_type")
    private ShellType shellType;

    @Column(name = "is_active")
    private boolean isActive;

    @Lob
    @Column(name = "output_buffer", columnDefinition = "TEXT")
    private String outputBuffer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "last_command_at")
    private LocalDateTime lastCommandAt;

    protected TerminalSession() {
    }

    public TerminalSession(TerminalSessionId id, String name, 
                          String workingDirectory, ShellType shellType) {
        this.id = id;
        this.name = name;
        this.workingDirectory = workingDirectory;
        this.shellType = shellType;
        this.isActive = true;
        this.outputBuffer = "";
        this.createdAt = LocalDateTime.now();

        Events.raise(new TerminalSessionCreatedEvent(id, name));
    }

    public void executeCommand(String command) {
        if (!isActive) {
            throw new IllegalStateException("Terminal session is not active");
        }
        this.lastCommandAt = LocalDateTime.now();
        Events.raise(new CommandExecutedEvent(id, command));
    }

    public void appendOutput(String output) {
        this.outputBuffer += output + "\n";
    }

    public void changeDirectory(String newDirectory) {
        this.workingDirectory = newDirectory;
    }

    public void close() {
        this.isActive = false;
        Events.raise(new TerminalSessionClosedEvent(id));
    }

    public TerminalSessionId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public ShellType getShellType() {
        return shellType;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getOutputBuffer() {
        return outputBuffer;
    }

    public LocalDateTime getLastCommandAt() {
        return lastCommandAt;
    }
}

