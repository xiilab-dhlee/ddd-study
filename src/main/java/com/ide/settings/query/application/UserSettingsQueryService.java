package com.ide.settings.query.application;

import com.ide.settings.command.domain.UserSettings;
import com.ide.settings.command.domain.UserSettingsId;
import com.ide.settings.command.domain.UserSettingsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserSettingsQueryService {
    
    private UserSettingsRepository userSettingsRepository;

    public UserSettingsQueryService(UserSettingsRepository userSettingsRepository) {
        this.userSettingsRepository = userSettingsRepository;
    }

    public Optional<UserSettings> getSettings(String settingsId) {
        return userSettingsRepository.findById(new UserSettingsId(settingsId));
    }

    public Optional<UserSettings> getSettingsByUserId(String userId) {
        return userSettingsRepository.findByUserId(userId);
    }
}

