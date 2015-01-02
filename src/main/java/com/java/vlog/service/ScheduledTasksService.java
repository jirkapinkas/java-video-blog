package com.java.vlog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jsitemapgenerator.WebSitemapGenerator;

@Service
public class ScheduledTasksService {

	@Autowired
	private SitemapService sitemapService;
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasksService.class);
	
	@Scheduled(cron="0 0 2 * * *")
	public void pingGoogle() {
		WebSitemapGenerator webSitemapGenerator = new WebSitemapGenerator("http://www.javavids.com");
		webSitemapGenerator.pingGoogle();
		logger.info("pinged google with new sitemap");
	}
}
