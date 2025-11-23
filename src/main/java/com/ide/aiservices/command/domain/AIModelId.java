package com.ide.aiservices.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AIModelId implements Serializable {
    
    @Column(name = "model_id")
    private String id;

    protected AIModelId() {
    }

    public AIModelId(String id) {
        this.id = id;
    }

    public static AIModelId generate() {
        return new AIModelId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AIModelId aiModelId = (AIModelId) o;
        return Objects.equals(id, aiModelId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

