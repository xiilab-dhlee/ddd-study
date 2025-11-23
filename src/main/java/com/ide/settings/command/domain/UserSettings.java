package com.ide.settings.command.domain;

import com.ide.common.event.Events;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "user_settings")
public class UserSettings {
    
    @EmbeddedId
    private UserSettingsId id;
    
    @Column(name = "user_id")
    private String userId;
    
    @Embedded
    private EditorSettings editorSettings;
    
    @Embedded
    private ThemeSettings themeSettings;
    
    @ElementCollection
    @CollectionTable(name = "keybindings", 
                    joinColumns = @JoinColumn(name = "settings_id"))
    @MapKeyColumn(name = "command")
    @Column(name = "keybinding")
    private Map<String, String> keybindings;
    
    @Column(name = "sync_enabled")
    private boolean syncEnabled;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    protected UserSettings() {
    }

    public UserSettings(UserSettingsId id, String userId) {
        this.id = id;
        this.userId = userId;
        this.editorSettings = EditorSettings.defaultSettings();
        this.themeSettings = ThemeSettings.defaultTheme();
        this.keybindings = new HashMap<>();
        this.syncEnabled = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        
        Events.raise(new UserSettingsCreatedEvent(id, userId));
    }

    public void updateEditorSettings(EditorSettings newSettings) {
        this.editorSettings = newSettings;
        this.updatedAt = LocalDateTime.now();
        Events.raise(new SettingsUpdatedEvent(id, "editor"));
    }

    public void updateTheme(ThemeSettings newTheme) {
        this.themeSettings = newTheme;
        this.updatedAt = LocalDateTime.now();
        Events.raise(new SettingsUpdatedEvent(id, "theme"));
    }

    public void setKeybinding(String command, String keybinding) {
        this.keybindings.put(command, keybinding);
        this.updatedAt = LocalDateTime.now();
    }

    public void enableSync() {
        this.syncEnabled = true;
        Events.raise(new SettingsSyncEnabledEvent(id));
    }

    public void disableSync() {
        this.syncEnabled = false;
    }

    // Getters
    public UserSettingsId getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public EditorSettings getEditorSettings() {
        return editorSettings;
    }

    public ThemeSettings getThemeSettings() {
        return themeSettings;
    }

    public Map<String, String> getKeybindings() {
        return keybindings;
    }

    public boolean isSyncEnabled() {
        return syncEnabled;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

