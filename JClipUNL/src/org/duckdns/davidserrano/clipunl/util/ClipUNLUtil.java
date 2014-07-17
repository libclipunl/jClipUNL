package org.duckdns.davidserrano.clipunl.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
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

	public static String buildQueryString(Map<ClipUNLParameterType, String> map) {
		String queryString = "";

		for (final Entry<ClipUNLParameterType, String> entry : map.entrySet()) {
			try {
				final String key = URLEncoder.encode(entry.getKey().getCode(),
						ClipUNLConstants.CLIP_ENCODING);

				final String value = URLEncoder.encode(entry.getValue(),
						ClipUNLConstants.CLIP_ENCODING);
				
				final String pair = key + "=" + value;
				
				if (queryString.isEmpty()) {
					queryString = pair;
				} else {
					queryString += "&" + pair;
				}
				
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		}

		return queryString;
	}

	/*
	 * From: http://stackoverflow.com/a/13592567
	 */
	public static Map<ClipUNLParameterType, String> splitQueryString(String url)
			throws UnsupportedEncodingException {
		final String[] qs = url.split("\\?");
		final String url_ = qs.length > 1 ? qs[1] : url;

		final Map<ClipUNLParameterType, String> query_pairs = new LinkedHashMap<ClipUNLParameterType, String>();
		final String[] pairs = url_.split("&");
		for (String pair : pairs) {
			final int idx = pair.indexOf("=");
			final String key = idx > 0 ? URLDecoder.decode(
					pair.substring(0, idx), ClipUNLConstants.CLIP_ENCODING)
					: pair;

			final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder
					.decode(pair.substring(idx + 1),
							ClipUNLConstants.CLIP_ENCODING) : null;

			final ClipUNLParameterType code = ClipUNLParameterType.from(key);

			if (code != null) {
				query_pairs.put(ClipUNLParameterType.from(key), value);
			}
		}
		return query_pairs;

	}
}
