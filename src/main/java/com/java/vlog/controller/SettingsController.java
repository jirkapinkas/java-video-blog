package com.java.vlog.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.java.vlog.entity.Settings;
import com.java.vlog.service.SettingsService;

@Named
@Scope("singleton")
public class SettingsController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SettingsService settingsService;
	
	private Settings settings;

	@PostConstruct
	public void loadSettings() {
		settings = settingsService.find();
	}

	public Settings getSettings() {
		return settings;
	}
	
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	public void save() {
		settingsService.save(settings);
		Messages.addFlashGlobalInfo("Settings saved!");
	}
}
