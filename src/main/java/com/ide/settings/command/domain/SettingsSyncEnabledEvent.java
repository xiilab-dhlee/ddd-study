package com.ide.settings.command.domain;

import com.myshop.common.event.Event;

public class SettingsSyncEnabledEvent extends Event {
    
    private UserSettingsId settingsId;

    public SettingsSyncEnabledEvent(UserSettingsId settingsId) {
        super();
        this.settingsId = settingsId;
    }

    public UserSettingsId getSettingsId() {
        return settingsId;
    }
}

