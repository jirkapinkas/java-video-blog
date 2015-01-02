package com.java.vlog.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.java.vlog.entity.Group;
import com.java.vlog.service.GroupService;

@Named
@Scope("view")
public class IndexController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Group> groups;

	private Group group;

	@Autowired
	private GroupService groupService;

	private UploadedFile uploadedFile;

	@PostConstruct
	public void loadGroups() {
		groups = groupService.findAllWithItems();
	}

	public void loadGroup(String shortName) {
		group = groupService.findOneWithItems(shortName);
	}

	public String save() throws IOException {
		if (uploadedFile.getSize() != 0) {
			groupService.save(group, uploadedFile.getContents());
		} else {
			groupService.save(group);
		}
		return "index?faces-redirect=true";
	}

	public void cancel() {
		group = new Group();
	}

	public void delete(Group group) {
		groupService.delete(group);
		groups.remove(group);
	}

	public Group getGroup() {
		if (group == null) {
			group = new Group();
		}
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

}