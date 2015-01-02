package com.java.vlog.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.java.vlog.entity.StaticContent;
import com.java.vlog.entity.StaticContent.Location;
import com.java.vlog.service.StaticContentService;

@Named
@Scope("singleton")
public class StaticContentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StaticContentService staticContentService;

	private List<StaticContent> staticContentsHomepage;

	private List<StaticContent> staticContentsLeft;

	private List<StaticContent> staticContentsRight;

	private List<StaticContent> staticContentBanner;

	private List<StaticContent> staticContentFooter;

	private StaticContent staticContent;

	@PostConstruct
	public void loadAll() {
		staticContentsHomepage = staticContentService.findByLocation(Location.HOMEPAGE);
		staticContentsLeft = staticContentService.findByLocation(Location.LEFT);
		staticContentsRight = staticContentService.findByLocation(Location.RIGHT);
		staticContentBanner = staticContentService.findByLocation(Location.BANNER);
		staticContentFooter = staticContentService.findByLocation(Location.FOOTER);
	}

	public List<StaticContent> getStaticContents(String type) {
		Location location = Location.valueOf(type.toUpperCase(Locale.ENGLISH));
		switch (location) {
		case HOMEPAGE:
			return staticContentsHomepage;
		case LEFT:
			return staticContentsLeft;
		case RIGHT:
			return staticContentsRight;
		case BANNER:
			return staticContentBanner;
		case FOOTER:
			return staticContentFooter;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public StaticContent getStaticContent() {
		if (staticContent == null) {
			staticContent = new StaticContent();
		}
		return staticContent;
	}

	public void setStaticContent(StaticContent staticContent) {
		this.staticContent = staticContent;
	}

	/**
	 * insert operation
	 * 
	 * @param type
	 */
	public void save(String type) {
		save(type, this.staticContent);
		staticContent = new StaticContent();
		loadAll();
	}

	/**
	 * update operation
	 * 
	 * @param type
	 * @param staticContent
	 */
	public void save(String type, StaticContent staticContent) {
		staticContent.setLocation(Location.valueOf(type.toUpperCase(Locale.ENGLISH)));
		staticContentService.save(staticContent);
	}

	public void delete(StaticContent staticContent) {
		staticContentService.delete(staticContent);
		loadAll();
	}
}
