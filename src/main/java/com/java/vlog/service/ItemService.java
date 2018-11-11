package com.java.vlog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.vlog.entity.Item;
import com.java.vlog.repository.ItemRepository;
import com.java.vlog.util.MyUtil;

@Transactional
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public static final int FIRST_PAGE = 0;

	public static final int PAGE_10_ITEMS = 10;

	public void save(Item item) {
		if (item.getId() == null) {
			item.setShortName(MyUtil.generatePermalink(item.getName()));
			item.setPublishedDate(new Date());
		}
		itemRepository.save(item);
	}

	public Item findOne(String shortName) {
		return itemRepository.findByShortName(shortName);
	}

	public void delete(Item item) {
		itemRepository.delete(item);
	}

	public List<Item> findLatest(int page, int count) {
		return itemRepository.findAll(PageRequest.of(page, count, Direction.DESC, "publishedDate")).getContent();
	}

	public void addTag(String tagName, Item item) {
		tagName = tagName.trim().toLowerCase();
		String[] tagArray = item.getTagArray();
		if(tagArray != null) {
			for (String tag : tagArray) {
				if(tag.equals(tagName)) {
					// do not allow duplicit tags
					return;
				}
			}
		}

		String tags = item.getTags();
		if(tags == null) {
			tags = "";
		}
		tags += tagName + "\n";
		
		item.setTags(tags);
		itemRepository.save(item);
	}

	public Item findOneWithTags(Integer id) {
		return itemRepository.findById(id).orElse(null);
	}
	
	public Item findOneWithTags(String shortName) {
		return itemRepository.findByShortName(shortName);
	}

	public void deleteTag(Item item, String removeTag) {
		removeTag = removeTag.trim();
		String[] tagArray = item.getTagArray();
		String newTags = "";
		for (String tag : tagArray) {
			if(!tag.equals(removeTag)) {
				newTags += tag + "\n";
			}
		}
		item.setTags(newTags);
		itemRepository.save(item);
	}
	
	public List<Item> findWithTag(String encodedTag) {
		ArrayList<Item> resultList = new ArrayList<Item>();
		//TODO udelat efektivneji, tohle asi muze zatezovat databazi a pamet na serveru
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			String[] tagArray = item.getTagArray();
			for (String tag : tagArray) {
				if(MyUtil.generatePermalink(tag).equals(encodedTag)) {
					resultList.add(item);
				}
			}
		}
		return resultList;
	}

}