package org.duckdns.davidserrano.clipunl.scraper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NetworkErrorException;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ClipUNLScraper {

	protected static Document lastDocument;

	protected static Document getDocument(final ClipUNLSession session,
			final ClipUNLPath path,
			final Map<ClipUNLParameterType, String> data, final Method method) {

		try {
			// System.out.println(">> " + method + " " + path.getURL() + " " +
			// data);
			String url = path.getURL();

			if (method.equals(Method.GET)) {
				String qs = ClipUNLUtil.buildQueryString(data);
				url += "?" + qs;
			}

			Connection connection = Jsoup.connect(url)
					.timeout(ClipUNLConstants.CLIP_NETWORK_TIMEOUT)
					.cookies(session.getCookies());

			if (method.equals(Method.POST)) {
				for (final Entry<ClipUNLParameterType, String> entry : data
						.entrySet()) {
					connection = connection.data(entry.getKey().getCode(),
							entry.getValue());
				}
			}

			final Response response = connection.execute().method(method);

			final Map<String, String> cookies = response.cookies();

			if (cookies.size() > 0) {
				session.setCookies(response.cookies());
			}

			lastDocument = response.parse();
			return lastDocument;

		} catch (IOException e) {
			throw new NetworkErrorException(path);
		}

	}

	protected static Document getDocument(final ClipUNLSession session,
			final ClipUNLPath path, final Map<ClipUNLParameterType, String> data) {
		return getDocument(session, path, data, Method.POST);
	}

	protected static Document getDocument(final ClipUNLSession session,
			final ClipUNLPath path) {
		return getDocument(session, path,
				new HashMap<ClipUNLParameterType, String>(), Method.GET);
	}

	protected static Document getLastDocument() {
		return lastDocument;
	}
}
