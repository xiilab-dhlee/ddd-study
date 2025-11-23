package com.ide.agent.command.domain;

import com.myshop.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agent_task")
public class AgentTask {
    
    @EmbeddedId
    private AgentId id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "task_type")
    private AgentTaskType taskType;
    
    @Column(name = "description", length = 2000)
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AgentTaskStatus status;
    
    @Column(name = "context_files", length = 1000)
    private String contextFiles;
    
    @Lob
    @Column(name = "result", columnDefinition = "TEXT")
    private String result;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    protected AgentTask() {
    }

    public AgentTask(AgentId id, AgentTaskType taskType, String description, String contextFiles) {
        this.id = id;
        this.taskType = taskType;
        this.description = description;
        this.contextFiles = contextFiles;
        this.status = AgentTaskStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        
        Events.raise(new AgentTaskCreatedEvent(id, taskType, description));
    }

    public void start() {
        if (this.status != AgentTaskStatus.PENDING) {
            throw new IllegalStateException("Task already started");
        }
        this.status = AgentTaskStatus.IN_PROGRESS;
        Events.raise(new AgentTaskStartedEvent(id));
    }

    public void complete(String result) {
        if (this.status != AgentTaskStatus.IN_PROGRESS) {
            throw new IllegalStateException("Task not in progress");
        }
        this.status = AgentTaskStatus.COMPLETED;
        this.result = result;
        this.completedAt = LocalDateTime.now();
        Events.raise(new AgentTaskCompletedEvent(id, result));
    }

    public void fail(String errorMessage) {
        this.status = AgentTaskStatus.FAILED;
        this.result = errorMessage;
        this.completedAt = LocalDateTime.now();
        Events.raise(new AgentTaskFailedEvent(id, errorMessage));
    }

    // Getters
    public AgentId getId() {
        return id;
    }

    public AgentTaskType getTaskType() {
        return taskType;
    }

    public String getDescription() {
        return description;
    }

    public AgentTaskStatus getStatus() {
        return status;
    }

    public String getContextFiles() {
        return contextFiles;
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

