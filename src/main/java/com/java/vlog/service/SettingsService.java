package com.java.vlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.vlog.entity.Settings;
import com.java.vlog.repository.SettingsRepository;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	public void save(Settings settings) {
		if (settings.getId() != null) {
			Settings managedSettings = settingsRepository.findOne(settings.getId());
			if (settings.getAdminPassword() != null && !settings.getAdminPassword().isEmpty()) {
				settings.setAdminPassword(new BCryptPasswordEncoder().encode(settings.getAdminPassword()));
			} else {
				settings.setAdminPassword(managedSettings.getAdminPassword());
			}
		}
		settingsRepository.save(settings);
	}

	public Settings find() {
		List<Settings> settings = settingsRepository.findAll();
		if (settings.size() == 0) {
			return null;
		} else if (settings.size() == 1) {
			return settings.get(0);
		} else {
			throw new UnsupportedOperationException("settings can exist only once in database");
		}
	}

}
