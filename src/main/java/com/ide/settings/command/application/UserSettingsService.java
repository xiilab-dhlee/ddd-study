package com.ide.settings.command.application;

import com.ide.settings.command.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSettingsService {

    private UserSettingsRepository userSettingsRepository;

    public UserSettingsService(UserSettingsRepository userSettingsRepository) {
        this.userSettingsRepository = userSettingsRepository;
    }

    @Transactional
    public UserSettingsId createSettings(String userId) {
        UserSettingsId id = UserSettingsId.generate();
        UserSettings settings = new UserSettings(id, userId);
        userSettingsRepository.save(settings);
        return id;
    }

    @Transactional
    public void updateEditorSettings(String settingsId, EditorSettings editorSettings) {
        UserSettings settings = userSettingsRepository.findById(new UserSettingsId(settingsId))
                .orElseThrow(() -> new NoUserSettingsException());
        settings.updateEditorSettings(editorSettings);
    }

    @Transactional
    public void updateTheme(String settingsId, ThemeSettings themeSettings) {
        UserSettings settings = userSettingsRepository.findById(new UserSettingsId(settingsId))
                .orElseThrow(() -> new NoUserSettingsException());
        settings.updateTheme(themeSettings);
    }

    @Transactional
    public void enableSync(String settingsId) {
        UserSettings settings = userSettingsRepository.findById(new UserSettingsId(settingsId))
                .orElseThrow(() -> new NoUserSettingsException());
        settings.enableSync();
    }
}

