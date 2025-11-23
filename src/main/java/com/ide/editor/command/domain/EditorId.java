package com.ide.editor.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EditorId implements Serializable {

    @Column(name = "editor_id")
    private String id;

    protected EditorId() {
    }

    public EditorId(String id) {
        this.id = id;
    }

    public static EditorId generate() {
        return new EditorId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditorId editorId = (EditorId) o;
        return Objects.equals(id, editorId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}

