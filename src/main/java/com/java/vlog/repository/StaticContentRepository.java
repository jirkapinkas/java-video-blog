package com.java.vlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.vlog.entity.StaticContent;
import com.java.vlog.entity.StaticContent.Location;

public interface StaticContentRepository extends JpaRepository<StaticContent, Integer> {

	List<StaticContent> findByLocation(Location location);
}
