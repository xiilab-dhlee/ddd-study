package com.ide.languageintelligence.query.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CodeCompletionDTO {
    
    private String completionId;
    private String filePath;
    private int triggerPosition;
    private List<CompletionItemDTO> items;
    private LocalDateTime createdAt;

    public CodeCompletionDTO(String completionId, String filePath, int triggerPosition,
                            List<CompletionItemDTO> items, LocalDateTime createdAt) {
        this.completionId = completionId;
        this.filePath = filePath;
        this.triggerPosition = triggerPosition;
        this.items = items;
        this.createdAt = createdAt;
    }

    public String getCompletionId() {
        return completionId;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getTriggerPosition() {
        return triggerPosition;
    }

    public List<CompletionItemDTO> getItems() {
        return items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

