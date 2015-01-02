package com.java.vlog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vlog_settings")
public class Settings extends MasterEntity {

	private static final long serialVersionUID = 1L;

	private String websiteUrl;

	private String websiteName;

	private String websiteDescription;

	private String adminName;

	private String adminPassword;

	private boolean editStaticContent;

	public boolean isEditStaticContent() {
		return editStaticContent;
	}

	public void setEditStaticContent(boolean editStaticContent) {
		this.editStaticContent = editStaticContent;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getWebsiteDescription() {
		return websiteDescription;
	}

	public void setWebsiteDescription(String websiteDescription) {
		this.websiteDescription = websiteDescription;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Settings [websiteUrl=" + websiteUrl + ", websiteName=" + websiteName + ", websiteDescription=" + websiteDescription + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", editStaticContent=" + editStaticContent + "]";
	}

}
