package com.java.vlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.vlog.entity.GroupIcon;
import com.java.vlog.repository.GroupIconRepository;

@Transactional
@Service
public class GroupIconService {

	@Autowired
	private GroupIconRepository groupIconRepository;

	@CacheEvict(value = "icon", allEntries = true)
	public void save(GroupIcon groupIcon) {
		groupIconRepository.save(groupIcon);
	}

	@Cacheable("icon")
	public byte[] findIcon(String shortName) {
		return groupIconRepository.findByGroupShortName(shortName).getIcon();
	}
	
	public GroupIcon findOne(int id) {
		return groupIconRepository.findById(id).orElse(null);
	}
	
	public void remove(int id) {
		groupIconRepository.deleteById(id);
	}

}
