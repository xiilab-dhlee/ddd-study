package com.ide.agent.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AgentId implements Serializable {

    @Column(name = "agent_id")
    private String id;

    protected AgentId() {
    }

    public AgentId(String id) {
        this.id = id;
    }

    public static AgentId generate() {
        return new AgentId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentId agentId = (AgentId) o;
        return Objects.equals(id, agentId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

