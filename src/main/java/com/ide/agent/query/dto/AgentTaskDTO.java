package com.ide.agent.query.dto;

import java.time.LocalDateTime;

public class AgentTaskDTO {
    
    private String agentId;
    private String taskType;
    private String description;
    private String status;
    private String result;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public AgentTaskDTO(String agentId, String taskType, String description, String status,
                       String result, LocalDateTime createdAt, LocalDateTime completedAt) {
        this.agentId = agentId;
        this.taskType = taskType;
        this.description = description;
        this.status = status;
        this.result = result;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
}

