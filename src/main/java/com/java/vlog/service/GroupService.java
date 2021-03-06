package com.java.vlog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.vlog.entity.Group;
import com.java.vlog.entity.GroupIcon;
import com.java.vlog.repository.GroupRepository;
import com.java.vlog.util.MyUtil;

@Transactional
@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GroupIconService groupIconService;

	public List<Group> findAllWithItems() {
		return groupRepository.findAllWithItems();
	}

	public Group findOneWithItems(String shortName) {
		return groupRepository.findByShortNameWithItems(shortName);
	}

	public Group findOne(String shortName) {
		return groupRepository.findByShortName(shortName);
	}

	public void delete(Group group) {
		groupRepository.delete(group);
	}

	public void save(Group group) {
		if (group.getId() == null) {
			group.setShortName(MyUtil.generatePermalink(group.getName()));
			group.setPublishedDate(new Date());
		}
		groupRepository.save(group);
	}

	@Transactional
	public void save(Group group, byte[] contents) {
		save(group);
		GroupIcon groupIcon = group.getGroupIcon();
		groupIcon = new GroupIcon(); // TODO when editing, old icon stays in database
		groupIcon.setIcon(contents);
		groupIcon.setGroup(group);
		groupIconService.save(groupIcon);
		group.setGroupIcon(groupIcon);
		save(group);
	}
}
