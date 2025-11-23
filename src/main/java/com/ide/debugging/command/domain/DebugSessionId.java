package com.ide.debugging.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class DebugSessionId implements Serializable {
    
    @Column(name = "session_id")
    private String id;

    protected DebugSessionId() {
    }

    public DebugSessionId(String id) {
        this.id = id;
    }

    public static DebugSessionId generate() {
        return new DebugSessionId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebugSessionId that = (DebugSessionId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

