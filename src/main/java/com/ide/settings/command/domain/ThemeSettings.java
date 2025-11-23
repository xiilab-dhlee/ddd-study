package com.ide.settings.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ThemeSettings {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "theme")
    private Theme theme;
    
    @Column(name = "icon_theme")
    private String iconTheme;

    protected ThemeSettings() {
    }

    public ThemeSettings(Theme theme, String iconTheme) {
        this.theme = theme;
        this.iconTheme = iconTheme;
    }

    public static ThemeSettings defaultTheme() {
        return new ThemeSettings(Theme.DARK, "default");
    }

    public Theme getTheme() {
        return theme;
    }

    public String getIconTheme() {
        return iconTheme;
    }

    public enum Theme {
        LIGHT, DARK, HIGH_CONTRAST
    }
}

