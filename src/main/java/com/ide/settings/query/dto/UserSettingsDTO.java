package com.ide.settings.query.dto;

import java.util.Map;

public class UserSettingsDTO {
    
    private String settingsId;
    private String userId;
    private int fontSize;
    private String fontFamily;
    private int tabSize;
    private String theme;
    private boolean syncEnabled;
    private Map<String, String> keybindings;

    public UserSettingsDTO(String settingsId, String userId, int fontSize, String fontFamily,
                          int tabSize, String theme, boolean syncEnabled, Map<String, String> keybindings) {
        this.settingsId = settingsId;
        this.userId = userId;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.tabSize = tabSize;
        this.theme = theme;
        this.syncEnabled = syncEnabled;
        this.keybindings = keybindings;
    }

    public String getSettingsId() {
        return settingsId;
    }

    public String getUserId() {
        return userId;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getTabSize() {
        return tabSize;
    }

    public String getTheme() {
        return theme;
    }

    public boolean isSyncEnabled() {
        return syncEnabled;
    }

    public Map<String, String> getKeybindings() {
        return keybindings;
    }
}

