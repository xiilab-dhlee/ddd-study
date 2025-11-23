package com.ide.projectmanagement.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class WorkspaceId implements Serializable {

    @Column(name = "workspace_id")
    private String id;

    protected WorkspaceId() {
    }

    public WorkspaceId(String id) {
        this.id = id;
    }

    public static WorkspaceId generate() {
        return new WorkspaceId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkspaceId that = (WorkspaceId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

