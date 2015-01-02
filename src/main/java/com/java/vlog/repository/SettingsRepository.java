package com.java.vlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.vlog.entity.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Integer> {

}
