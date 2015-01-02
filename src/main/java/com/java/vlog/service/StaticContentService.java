package com.java.vlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.vlog.entity.StaticContent;
import com.java.vlog.entity.StaticContent.Location;
import com.java.vlog.repository.StaticContentRepository;

@Service
public class StaticContentService {

	@Autowired
	private StaticContentRepository staticContentRepository;

	public List<StaticContent> findByLocation(Location location) {
		return staticContentRepository.findByLocation(location);
	}

	public void save(StaticContent staticContent) {
		staticContentRepository.save(staticContent);
	}

	public void delete(StaticContent staticContent) {
		staticContentRepository.delete(staticContent);
	}
}
