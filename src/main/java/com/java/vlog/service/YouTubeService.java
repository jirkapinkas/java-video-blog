package com.java.vlog.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.vlog.util.MyUtil;
import com.java.vlog.youtube.json.YoutubeVideo;

@Service
public class YouTubeService {

	@Autowired
	@Qualifier("youtubeObjectMapper")
	private ObjectMapper objectMapper;

	private static final String youtubeApiUrl = "https://gdata.youtube.com/feeds/api/videos/";

	private static final String youtubeApiParams = "?v=2&alt=jsonc";

	public YoutubeVideo loadYoutubeVideo(String url) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		StringBuilder stringBuilder = new StringBuilder(youtubeApiUrl);
		stringBuilder.append(MyUtil.getYoutubeId(url));
		stringBuilder.append(youtubeApiParams);
		return objectMapper.readValue(new URL(stringBuilder.toString()), YoutubeVideo.class);
	}

}
