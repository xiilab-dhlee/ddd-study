package com.ide.agent.command.domain;

import com.ide.common.event.Event;

public class AgentTaskStartedEvent extends Event {

    private AgentId agentId;

    public AgentTaskStartedEvent(AgentId agentId) {
        super();
        this.agentId = agentId;
    }

    public AgentId getAgentId() {
        return agentId;
    }
}

