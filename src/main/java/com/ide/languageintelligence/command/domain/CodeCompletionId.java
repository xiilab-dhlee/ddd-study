package com.ide.languageintelligence.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CodeCompletionId implements Serializable {
    
    @Column(name = "completion_id")
    private String id;

    protected CodeCompletionId() {
    }

    public CodeCompletionId(String id) {
        this.id = id;
    }

    public static CodeCompletionId generate() {
        return new CodeCompletionId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeCompletionId that = (CodeCompletionId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

