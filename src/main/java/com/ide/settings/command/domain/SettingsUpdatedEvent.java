package com.ide.settings.command.domain;

import com.ide.common.event.Event;

public class SettingsUpdatedEvent extends Event {

    private UserSettingsId settingsId;
    private String settingsType;

    public SettingsUpdatedEvent(UserSettingsId settingsId, String settingsType) {
        super();
        this.settingsId = settingsId;
        this.settingsType = settingsType;
    }

    public UserSettingsId getSettingsId() {
        return settingsId;
    }

    public String getSettingsType() {
        return settingsType;
    }
}

