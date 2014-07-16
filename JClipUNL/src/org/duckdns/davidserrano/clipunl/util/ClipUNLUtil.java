package org.duckdns.davidserrano.clipunl.util;

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
}
