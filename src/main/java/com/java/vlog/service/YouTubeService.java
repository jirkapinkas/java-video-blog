package com.java.vlog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.vlog.util.MyUtil;
import com.java.vlog.youtube.json.YoutubeVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class YouTubeService {

	@Autowired
	private ObjectMapper objectMapper;

	private static final String YOUTUBE_API_URL = "https://gdata.youtube.com/feeds/api/videos/";

	private static final String YOUTUBE_API_PARAMS = "?v=2&alt=jsonc";

	public YoutubeVideo loadYoutubeVideo(String url) throws IOException {
		String stringBuilder = YOUTUBE_API_URL + MyUtil.getYoutubeId(url) + YOUTUBE_API_PARAMS;
		return objectMapper.readValue(new URL(stringBuilder), YoutubeVideo.class);
	}

}
