package com.java.vlog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class DynamicContent extends MasterEntity {

	private static final long serialVersionUID = 1L;

	@Size(min = 1, message = "Name is required!")
	@Column(nullable = false, unique = true)
	private String name;

	@Size(min = 1, message = "Short name is required!")
	@Column(name = "short_name", nullable = false, unique = true)
	private String shortName;

	@Size(min = 1, message = "Description is required!")
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(length = Integer.MAX_VALUE, nullable = false)
	private String description;

	@Size(min = 1, message = "Short description is required!")
	@Column(name = "short_description", length = 1000, nullable = false)
	private String shortDescription;

	@NotNull
	@Column(name = "published_date", nullable = false)
	private Date publishedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

}
