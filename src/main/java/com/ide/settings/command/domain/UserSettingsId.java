package com.ide.settings.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserSettingsId implements Serializable {
    
    @Column(name = "settings_id")
    private String id;

    protected UserSettingsId() {
    }

    public UserSettingsId(String id) {
        this.id = id;
    }

    public static UserSettingsId generate() {
        return new UserSettingsId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSettingsId that = (UserSettingsId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

