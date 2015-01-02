package com.java.vlog.MIGRACE;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Migrace {

	@XmlElement(name = "group")
	private List<MigGroup> groups;

	@XmlElement(name = "item")
	private List<MigItem> items;

	public List<MigGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<MigGroup> groups) {
		this.groups = groups;
	}

	public List<MigItem> getItems() {
		return items;
	}

	public void setItems(List<MigItem> items) {
		this.items = items;
	}

}
