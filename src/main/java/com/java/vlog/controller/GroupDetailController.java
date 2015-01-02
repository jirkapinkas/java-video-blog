package com.java.vlog.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.java.vlog.entity.Group;
import com.java.vlog.entity.Item;
import com.java.vlog.service.GroupService;
import com.java.vlog.service.ItemService;
import com.java.vlog.service.YouTubeService;
import com.java.vlog.youtube.json.YoutubeVideo;

@Named
@Scope("view")
public class GroupDetailController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ItemService itemService;

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private YouTubeService youTubeService;

	private Item item;

	private Group group;

	public void loadGroup(String name) {
		group = groupService.findOneWithItems(name);
	}

	public void deleteItem(Item item) {
		itemService.delete(item);
		loadGroup(group.getShortName());
	}

	public void saveItem() {
		item.setGroup(group);
		itemService.save(item);
		loadGroup(group.getShortName());
		item = new Item();
	}

	public void setItem(Item item) {
		this.item = itemService.findOneWithTags(item.getId());
//		this.item = item;
	}

	public Item getItem() {
		if (item == null) {
			item = new Item();
		}
		return item;
	}

	public void cancel() {
		item = new Item();
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void loadYoutubeVideo(String youtubeVideo) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		YoutubeVideo youtubeVideoData = youTubeService.loadYoutubeVideo(youtubeVideo);
		item.setYoutubeId(youtubeVideoData.getData().getId());
		item.setName(youtubeVideoData.getData().getTitle());
		item.setShortDescription(youtubeVideoData.getData().getDescription());
		item.setVideoLength(youtubeVideoData.getData().getDuration());
	}
	
	public void saveTag(String tagName) {
		itemService.addTag(tagName, item);
		setItem(item); // reload
	}

	public void delete(String tag) {
		itemService.deleteTag(item, tag);
		setItem(item); // reload
	}

}
