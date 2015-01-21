package com.java.vlog.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.java.vlog.util.MyUtil;

@Entity
@Table(name = "vlog_group")
public class Group extends DynamicContent {

	private static final long serialVersionUID = 1L;

	@Column(name = "group_order")
	private int groupOrder;

	@OrderBy("publishedDate")
	@OneToMany(mappedBy = "group", cascade = { CascadeType.REMOVE })
	private List<Item> items;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
	@JoinColumn(name = "group_icon_id")
	private GroupIcon groupIcon;

	/**
	 * Count video length of all items.
	 * 
	 * @return Video length of all items in format hh:mm:ss
	 */
	public String getDuration() {
		int totalSeconds = 0;
		if (items != null) {
			for (Item item : items) {
				totalSeconds += item.getVideoLength();
			}
		}
		return MyUtil.splitToComponentTimes(totalSeconds);
	}

	public GroupIcon getGroupIcon() {
		return groupIcon;
	}

	public void setGroupIcon(GroupIcon groupIcon) {
		this.groupIcon = groupIcon;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(int groupOrder) {
		this.groupOrder = groupOrder;
	}

	@Override
	public String toString() {
		return "Group [id=" + getId() + ", name=" + getName() + ", description=" + getDescription() + ", shortName=" + getShortName() + ", publishedDate=" + getPublishedDate() + ", groupOrder="
				+ groupOrder + ", shortDescription=" + getShortDescription() + "]";
	}

}
