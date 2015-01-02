package com.java.vlog.controller;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.java.vlog.entity.Item;
import com.java.vlog.service.ItemService;

@Named
@Scope("view")
public class ItemDetailController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;

	@Autowired
	private ItemService itemService;
	
	public void loadItem(String shortName) {
		item = itemService.findOneWithTags(shortName);
	}

	public Item getItem() {
		return item;
	}
	
}
