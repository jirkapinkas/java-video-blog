package com.java.vlog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "vlog_static_content")
public class StaticContent extends MasterEntity {

	private static final long serialVersionUID = 1L;

	public enum Location {
		LEFT, RIGHT, FOOTER, BANNER, HOMEPAGE
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Location location;

	private String name;

	@Lob
	@Type(type = "org.hibernate.type.StringClobType")
	@Column(length = Integer.MAX_VALUE, nullable = false)
	private String description;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "StaticContent [id=" + getId() + ", location=" + location + ", name=" + name + ", description=" + description + "]";
	}

}
