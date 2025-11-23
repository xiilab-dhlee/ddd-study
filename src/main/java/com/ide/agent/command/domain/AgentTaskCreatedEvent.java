package com.ide.agent.command.domain;

import com.ide.common.event.Event;

public class AgentTaskCreatedEvent extends Event {

    private AgentId agentId;
    private AgentTaskType taskType;
    private String description;

    public AgentTaskCreatedEvent(AgentId agentId, AgentTaskType taskType, String description) {
        super();
        this.agentId = agentId;
        this.taskType = taskType;
        this.description = description;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public AgentTaskType getTaskType() {
        return taskType;
    }

    public String getDescription() {
        return description;
    }
}

