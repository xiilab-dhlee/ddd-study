package com.ide.agent.command.domain;

import com.ide.common.event.Event;

public class AgentTaskFailedEvent extends Event {
    
    private AgentId agentId;
    private String errorMessage;

    public AgentTaskFailedEvent(AgentId agentId, String errorMessage) {
        super();
        this.agentId = agentId;
        this.errorMessage = errorMessage;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

