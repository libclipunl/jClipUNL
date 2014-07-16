package org.duckdns.davidserrano.clipunl.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ClipUNLUtil {
	public static String getFullName(final Document document) {
		final Elements elements = document.select("strong");

		if (elements.size() == 1) {
			return elements.text();
		} else {
			return null;
		}
	}
	
	/*
	 * From: http://stackoverflow.com/a/13592567
	 */
	public static Map<String, List<String>> splitQueryString(String url)
			throws UnsupportedEncodingException {
		final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
		final String[] pairs = url.split("&");
		for (String pair : pairs) {
			final int idx = pair.indexOf("=");
			final String key = idx > 0 ? URLDecoder.decode(
					pair.substring(0, idx), ClipUNLConstants.CLIP_ENCODING)
					: pair;
			if (!query_pairs.containsKey(key)) {
				query_pairs.put(key, new LinkedList<String>());
			}
			final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder
					.decode(pair.substring(idx + 1),
							ClipUNLConstants.CLIP_ENCODING) : null;
			query_pairs.get(key).add(value);
		}
		return query_pairs;

	}
}
