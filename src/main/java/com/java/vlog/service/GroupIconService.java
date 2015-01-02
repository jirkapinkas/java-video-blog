package com.java.vlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.vlog.entity.GroupIcon;
import com.java.vlog.repository.GroupIconRepository;

@Transactional
@Service
public class GroupIconService {

	@Autowired
	private GroupIconRepository groupIconRepository;

	public void save(GroupIcon groupIcon) {
		groupIconRepository.save(groupIcon);
	}

	public byte[] findIcon(String shortName) {
		return groupIconRepository.findByGroupShortName(shortName).getIcon();
	}

}
