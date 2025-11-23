package com.ide.debugging.query.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DebugSessionDTO {
    
    private String sessionId;
    private String programPath;
    private String status;
    private Integer currentLine;
    private String currentFile;
    private List<String> watchedVariables;
    private LocalDateTime startedAt;

    public DebugSessionDTO(String sessionId, String programPath, String status,
                          Integer currentLine, String currentFile, List<String> watchedVariables,
                          LocalDateTime startedAt) {
        this.sessionId = sessionId;
        this.programPath = programPath;
        this.status = status;
        this.currentLine = currentLine;
        this.currentFile = currentFile;
        this.watchedVariables = watchedVariables;
        this.startedAt = startedAt;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getProgramPath() {
        return programPath;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCurrentLine() {
        return currentLine;
    }

    public String getCurrentFile() {
        return currentFile;
    }

    public List<String> getWatchedVariables() {
        return watchedVariables;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }
}

