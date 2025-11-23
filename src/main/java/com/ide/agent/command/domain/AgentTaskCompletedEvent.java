package com.ide.agent.command.domain;

import com.myshop.common.event.Event;

public class AgentTaskCompletedEvent extends Event {
    
    private AgentId agentId;
    private String result;

    public AgentTaskCompletedEvent(AgentId agentId, String result) {
        super();
        this.agentId = agentId;
        this.result = result;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public String getResult() {
        return result;
    }
}

