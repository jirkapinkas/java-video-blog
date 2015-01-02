package com.java.vlog.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.java.vlog.entity.Item;
import com.java.vlog.service.ItemService;
import com.java.vlog.util.MyUtil;

@Named
@Scope("view")
public class TagController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Item> items;
	
	@Autowired
	private ItemService itemService;

	public String generatePermalink(String input) {
		return MyUtil.generatePermalink(input);
	}
	
	public void loadItems(String encodedTag) {
		items = itemService.findWithTag(encodedTag);
	}
	
	public List<Item> getItems() {
		return items;
	}
}
