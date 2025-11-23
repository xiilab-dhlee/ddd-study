package com.ide.terminal.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class TerminalSessionId implements Serializable {
    
    @Column(name = "terminal_session_id")
    private String id;

    protected TerminalSessionId() {
    }

    public TerminalSessionId(String id) {
        this.id = id;
    }

    public static TerminalSessionId generate() {
        return new TerminalSessionId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminalSessionId that = (TerminalSessionId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

