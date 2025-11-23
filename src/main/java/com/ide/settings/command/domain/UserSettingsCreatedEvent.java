package com.ide.settings.command.domain;

import com.ide.common.event.Event;

public class UserSettingsCreatedEvent extends Event {
    
    private UserSettingsId settingsId;
    private String userId;

    public UserSettingsCreatedEvent(UserSettingsId settingsId, String userId) {
        super();
        this.settingsId = settingsId;
        this.userId = userId;
    }

    public UserSettingsId getSettingsId() {
        return settingsId;
    }

    public String getUserId() {
        return userId;
    }
}

