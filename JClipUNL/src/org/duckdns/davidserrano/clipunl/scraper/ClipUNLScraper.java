package org.duckdns.davidserrano.clipunl.scraper;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NetworkErrorException;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ClipUNLScraper {

	protected static Document lastDocument;

	protected static Document getDocument(final ClipUNLSession session,
			final ClipUNLPath path, final Map<ClipUNLParameterType, String> data,
			final Method method) {

		try {
			// System.out.println(">> " + method + " " + path.getURL() + " " + data);
			final Map<String, String> data_ = new LinkedHashMap<String, String>();

			for (final Entry<ClipUNLParameterType, String> entry : data
					.entrySet()) {
				data_.put(entry.getKey().getCode(), entry.getValue());
			}

			final Response response = Jsoup
					.connect(path.getURL())
					.timeout(ClipUNLConstants.CLIP_NETWORK_TIMEOUT).data(data_)
					.cookies(session.getCookies()).execute().method(method);

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
