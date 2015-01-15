package com.java.vlog.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.vlog.controller.SettingsController;
import com.java.vlog.controller.StaticContentController;
import com.java.vlog.entity.Group;
import com.java.vlog.entity.GroupIcon;
import com.java.vlog.entity.Item;
import com.java.vlog.entity.Settings;
import com.java.vlog.entity.StaticContent;
import com.java.vlog.entity.StaticContent.Location;
import com.java.vlog.repository.GroupRepository;
import com.java.vlog.repository.ItemRepository;

@Service
public class InitDbService {

	@Autowired
	private ItemService itemService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private StaticContentService staticContentService;

	@Autowired
	private StaticContentController staticContentController;
	
	@Autowired
	private SettingsService settingsService;
	
	@Autowired
	private SettingsController settingsController;
	
	@Autowired
	private GroupIconService groupIconService;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@PostConstruct
	public void init() throws IOException {

		if(settingsService.find() == null) {
			
		// initialize database
			

		Group groupJava101 = constructGroup("Java Basics Tutorial", "Java basics tutorial for beginners. From installation of JDK to programming console applications in Eclipse IDE.",
				"Java basics tutorial for beginners. From installation of JDK to programming console applications in Eclipse IDE.");
		groupService.save(groupJava101);
		
		GroupIcon groupIcon = new GroupIcon();
		groupIcon.setGroup(groupJava101);
		groupIcon.setIcon(IOUtils.toByteArray(getClass().getResourceAsStream("/java-basics.png")));
		groupIconService.save(groupIcon);
		
		groupJava101.setGroupIcon(groupIcon);
		groupService.save(groupJava101);

		
		itemService
				.save(constructItem(
						"Difference between Java JRE and JDK",
						"<p>http://www.google.com?test=a&test=b <pre class='prettyprint'>int a = 10;</pre> JRE is a shortname for Java Runtime Edition. In short it's a bunch of applications and Java libraries that are required to run Java applications. This is what you need to run a Java application.</p>"
								+ "<p>You can download it on java.com, which is a site for people, that aren't programmers (aka normal people).</p>"
								+ "<p>But in order to create a Java application, you need more. You need JDK, which is a shortname for Java Development Kit. You can download it on oracle.com website. Just google jdk and you should be able to find it.</p><br><br>",
						"Difference between Java JRE and JDK plus how to install JDK (Java Development Kit).", "Hyk3BtCZOEY", groupJava101));
		itemService.save(constructItem("Second", "Second content", "Second cont.", "youtubelink2", groupJava101));
		
		staticContentService.save(constructStaticContent("", Location.HOMEPAGE, "This free online video tutorial in English on YouTube was started in late 2011 and it's ever growing collection of Java video tutorials. It's always a work in progress. I focus on tips and tricks with Eclipse and other sweet stuff you won't find in traditional books. Most tutorials are tips and tricks with an exception of Spring web application tutorial, which is focused on how to make a modern web application from scratch. I hope you will enjoy my work."));

		staticContentService.save(constructStaticContent("", Location.LEFT, 
"				<script async=\"async\" src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" +
"				<!-- javavids-vlevo -->\n" +
"				<ins class=\"adsbygoogle\"\n" +
"				     style=\"display:inline-block;width:160px;height:600px\"\n" +
"				     data-ad-client=\"ca-pub-7085637172523095\"\n" +
"				     data-ad-slot=\"1753062007\"></ins>\n" +
"				<script>\n" +
"				(adsbygoogle = window.adsbygoogle || []).push({});\n" +
"				</script>\n"
				));

		staticContentService.save(constructStaticContent("Share / Subscribe", Location.RIGHT, 
"		<!-- rss button -->\n" + 
"		<a href='http://feeds.feedburner.com/javavids' alt='JavaVids RSS feed'><img src='/resources/images/rss.png' border='0' alt='rss' title='rss' style='float:left;padding-right:10px'></a>\n" +  

"		<!-- twitter button -->\n" + 
"<a href='https://twitter.com/jirkapinkas' class='twitter-follow-button' data-show-count='false' data-size='large' data-show-screen-name='false'>Follow @jirkapinkas</a>\n" +
"<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>\n" +
"		<!-- youtube subscribe button -->\n" + 
"		<script src='https://apis.google.com/js/platform.js'></script>\n" + 
"		<div class='g-ytsubscribe' data-channel='seicocz' data-layout='default' data-count='default'></div>\n" + 
"		<!-- Google plus button -->\n" + 
"		<g:plusone></g:plusone>\n"
		));
		
		staticContentService.save(constructStaticContent("", Location.RIGHT, 
"				<script async=\"async\" src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + 
"				<!-- javavids-vpravo -->\n" + 
"				<ins class=\"adsbygoogle\"\n" + 
"				     style=\"display:inline-block;width:336px;height:280px\"\n" + 
"				     data-ad-client=\"ca-pub-7085637172523095\"\n" + 
"				     data-ad-slot=\"6322862405\"></ins>\n" + 
"				<script>\n" + 
"				(adsbygoogle = window.adsbygoogle || []).push({});\n" + 
"				</script>\n"
				));

		staticContentService.save(constructStaticContent("Search", Location.RIGHT, 
"<script>\n" + 
"  (function() {\n" + 
"    var cx = '014150908584257243850:ucmk-06fvfo';\n" + 
"    var gcse = document.createElement('script');\n" + 
"    gcse.type = 'text/javascript';\n" + 
"    gcse.async = true;\n" + 
"    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +\n" + 
"        '//www.google.com/cse/cse.js?cx=' + cx;\n" + 
"    var s = document.getElementsByTagName('script')[0];\n" + 
"    s.parentNode.insertBefore(gcse, s);\n" + 
"  })();\n" + 
"</script>\n" + 
"<gcse:search></gcse:search>\n"
		));
		
		staticContentService.save(constructStaticContent("Free online Java web application examples", Location.RIGHT, "Want to develop whole web applications which use database, security and more? See my github account, where are lot's of example projects: <br /> <a href='https://github.com/jirkapinkas?tab=repositories' target='_blank'> <img src='/resources/images/github.png' border='0' alt='github' /></a>"));

		staticContentService.save(constructStaticContent("", Location.FOOTER,
				"<div align='center'>&copy; <a href='http://plus.google.com/100661368478614117231' rel='author' target='_blank'>Jirka Pinkas</a>. All Rights Reserved.</div>"
				+ "<div align='center'>My other projects: <a href='http://www.topjavablogs.com' target='_blank'>Top Java Blogs</a>, <a href='http://www.sqlvids.com' target='_blank'>SQL video tutorials</a>, <a href='http://www.java-skoleni.cz' target='_blank'>Java školení (in Czech language)</a>, <a href='http://www.sql-skoleni.cz' target='_blank'>SQL školení (in Czech language)</a></div>"));

		staticContentService.save(constructStaticContent("", Location.BANNER, 
// google analytics
"		<script>\n" + 
"		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" + 
"		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + 
"		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" + 
"		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + 

"		  ga('create', 'UA-4384433-11', 'auto');\n" + 
"		  ga('send', 'pageview');\n" + 

"		</script>\n" +

// top google adsense banner
"<script async=\"async\" src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script> \n" +
"<!-- javavids-banner --> \n" +
"<ins class=\"adsbygoogle\" \n" +
"     style=\"display:inline-block;width:728px;height:90px\" \n" +
"     data-ad-client=\"ca-pub-7085637172523095\" \n" +
"     data-ad-slot=\"2694737335\"></ins> \n" +
"<script> \n" +
"(adsbygoogle = window.adsbygoogle || []).push({}); \n" +
"</script> \n"));
		
		Settings settings = new Settings();
		settings.setAdminName("admin");
		settings.setAdminPassword(new BCryptPasswordEncoder().encode("admin"));
		settings.setEditStaticContent(false);
		settings.setWebsiteDescription("This free online video tutorial in English on YouTube is a collection of Java video tutorials.");
		settings.setWebsiteUrl("http://www.javavids.com");
		settings.setWebsiteName("JavaVids: java videos");
		settingsService.save(settings);

		// force content loading in staticContentController and settingsController, 
		// because the bean could have been created before this bean and it 
		// loads data initialized with InitDbService.
		staticContentController.loadAll();
		settingsController.loadSettings();
		}
	}

	private StaticContent constructStaticContent(String name, Location location, String description) {
		StaticContent staticContent = new StaticContent();
		staticContent.setLocation(location);
		staticContent.setName(name);
		staticContent.setDescription(description);
		return staticContent;
	}

	private Group constructGroup(String name, String description, String shortDescription) throws IOException {
		Group group = new Group();
		group.setName(name);
		group.setDescription(description);
		group.setShortDescription(shortDescription);
		return group;
	}

	private Item constructItem(String name, String description, String shortDescription, String youtubeId, Group group) {
		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		item.setShortDescription(shortDescription);
		item.setYoutubeId(youtubeId);
		item.setGroup(group);
		return item;
	}

}
