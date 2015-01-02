package com.java.vlog.util;

import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MyUtil {
	
	private MyUtil() {
	}

	/**
	 * Split seconds to hours, minutes and seconds
	 * 
	 * @param seconds
	 *            Seconds
	 * @return Time in format hh:mm:ss
	 */
	public static String splitToComponentTimes(int seconds) {
		int hours = (int) seconds / 3600;
		int remainder = (int) seconds - hours * 3600;
		int mins = remainder / 60;
		remainder = remainder - mins * 60;
		int secs = remainder;
		DecimalFormat formatter = new DecimalFormat("00");
		StringBuilder stringBuilder = new StringBuilder(8);
		stringBuilder.append(formatter.format(hours));
		stringBuilder.append(":");
		stringBuilder.append(formatter.format(mins));
		stringBuilder.append(":");
		stringBuilder.append(formatter.format(secs));
		return stringBuilder.toString();
	}

	/**
	 * Generate permalink (without http://www.yourweb.com prefix)
	 * 
	 * @param input
	 *            Name (for example Java 101)
	 * @return Permalink part (for example java-101)
	 */
	public static String generatePermalink(String input) {
		String permalink = input.toLowerCase().trim();
		permalink = java.text.Normalizer.normalize(permalink, Normalizer.Form.NFD);
		permalink = permalink.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		permalink = permalink.replaceAll("[^\\p{Alpha}\\p{Digit}]+", "-");
		permalink = permalink.replaceAll("^-", "");
		permalink = permalink.replaceAll("-$", "");
		return permalink;
	}

	/**
	 * Retrieve Youtube ID from URL in this format:
	 * https://www.youtube.com/watch?v=IGIKPY6q1Qw
	 * 
	 * @param url
	 *            URL in format: https://www.youtube.com/watch?v=IGIKPY6q1Qw
	 * @return Youtube ID: IGIKPY6q1Qw
	 */
	public static String getYoutubeId(String url) {
		String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(url);
		if (matcher.find()) {
			return matcher.group();
		}
		return url;
	}

}
