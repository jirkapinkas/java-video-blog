package com.java.vlog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vlog_group_icon")
public class GroupIcon extends MasterEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY, mappedBy="groupIcon")
	private Group group;

	@Lob
	@Column(length = Integer.MAX_VALUE)
	private byte[] icon;

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}
}
