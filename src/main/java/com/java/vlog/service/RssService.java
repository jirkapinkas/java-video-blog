package com.java.vlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.vlog.entity.Item;
import com.java.vlog.entity.Settings;

import cz.jiripinkas.jsitemapgenerator.RssGenerator;
import cz.jiripinkas.jsitemapgenerator.WebPage;

@Service
public class RssService {

	@Autowired
	private ItemService itemService;

	@Autowired
	private SettingsService settingsService;

	public String constructRss() {
		Settings settings = settingsService.find();
		RssGenerator rssGenerator = new RssGenerator(settings.getWebsiteUrl(), settings.getWebsiteName(), settings.getWebsiteDescription());
		List<Item> items = itemService.findLatest(ItemService.FIRST_PAGE, ItemService.PAGE_10_ITEMS);
		for (Item item : items) {
			rssGenerator.addPage(new WebPage().setName(item.getName()).setShortName("video/" + item.getShortName() + ".html").setLastMod(item.getPublishedDate())
					.setShortDescription(item.getShortDescription()));
		}
		return rssGenerator.constructRss();
	}
}
