package com.java.vlog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.java.vlog.util.MyUtil;

@Entity
@Table(name = "vlog_item")
public class Item extends DynamicContent {

	private static final long serialVersionUID = 1L;

	@Size(min = 1, message = "YouTube link is required!")
	@Column(name = "youtube_link", unique = true, nullable = false)
	private String youtubeId;

	@Column(name = "video_length")
	private int videoLength;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id")
	private Group group;

	@Column(name = "tags", length = 1000)
	private String tags;

	public String[] getTagArray() {
		if (tags == null || tags.isEmpty()) {
			return null;
		}
		return tags.split("\n");
	}

	/**
	 * Transform video length from number to human-readable string.
	 * 
	 * @return Video length of all items in format hh:mm:ss
	 */
	public String getDuration() {
		return MyUtil.splitToComponentTimes(videoLength);
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getVideoLength() {
		return videoLength;
	}

	public void setVideoLength(int videoLength) {
		this.videoLength = videoLength;
	}

	@Override
	public String toString() {
		return "Item [id=" + getId() + ", name=" + getName() + ", shortName=" + getShortName() + "]";
	}

}
