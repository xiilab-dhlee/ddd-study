package com.ide.collaboration.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CollaborationSessionId implements Serializable {

    @Column(name = "collaboration_session_id")
    private String id;

    protected CollaborationSessionId() {
    }

    public CollaborationSessionId(String id) {
        this.id = id;
    }

    public static CollaborationSessionId generate() {
        return new CollaborationSessionId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollaborationSessionId that = (CollaborationSessionId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

