package com.java.vlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.vlog.entity.Group;
import com.java.vlog.entity.Item;
import com.java.vlog.util.MyUtil;

import cz.jiripinkas.jsitemapgenerator.WebPage;
import cz.jiripinkas.jsitemapgenerator.WebSitemapGenerator;

@Service
public class SitemapService {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private SettingsService settingsService;

	public String constructSitemap() {
		// TODO predelat sitemap generator aplikaci tak, aby radila url podle priority sestupne
		String websiteUrl = settingsService.find().getWebsiteUrl();
		List<Group> groups = groupService.findAllWithItems();
		WebSitemapGenerator webSitemapGenerator = new WebSitemapGenerator(websiteUrl);
		webSitemapGenerator.addPage(new WebPage().setPriority(1.0));
		for (Group group : groups) {
			webSitemapGenerator.addPage(new WebPage().setName("tutorial/" + group.getShortName() + ".html").setPriority(0.5).setLastMod(group.getPublishedDate()));
			List<Item> items = group.getItems();
			for (Item item : items) {
				webSitemapGenerator.addPage(new WebPage().setName("video/" + item.getShortName() + ".html").setPriority(0.4).setLastMod(group.getPublishedDate()));
				String[] tagArray = item.getTagArray();
				if(tagArray != null) {
					for (String tag : tagArray) {
						webSitemapGenerator.addPage(new WebPage().setName("tag/" + MyUtil.generatePermalink(tag) + ".html").setPriority(0.1));
					}
				}
			}
		}
		// TODO v sitemap generatoru dodelat metodu s touto funkcionalitou, at to nemusim delat tady rucne
		String[] sitemap = webSitemapGenerator.constructSitemap();
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : sitemap) {
			stringBuilder.append(string);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
