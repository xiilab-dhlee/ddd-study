package com.ide.terminal.query.dto;

import java.time.LocalDateTime;

public class TerminalSessionDTO {
    
    private String terminalSessionId;
    private String name;
    private String workingDirectory;
    private String shellType;
    private boolean isActive;
    private String outputBuffer;
    private LocalDateTime lastCommandAt;

    public TerminalSessionDTO(String terminalSessionId, String name, String workingDirectory,
                             String shellType, boolean isActive, String outputBuffer,
                             LocalDateTime lastCommandAt) {
        this.terminalSessionId = terminalSessionId;
        this.name = name;
        this.workingDirectory = workingDirectory;
        this.shellType = shellType;
        this.isActive = isActive;
        this.outputBuffer = outputBuffer;
        this.lastCommandAt = lastCommandAt;
    }

    public String getTerminalSessionId() {
        return terminalSessionId;
    }

    public String getName() {
        return name;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public String getShellType() {
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

