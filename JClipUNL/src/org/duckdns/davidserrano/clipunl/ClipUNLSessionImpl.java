package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;

public class ClipUNLSessionImpl extends ClipUNLScraper implements Serializable,
		ClipUNLSession {
	private static final long serialVersionUID = 1018884267769939415L;
	private Map<String, String> cookies;

	private String fullName;

	private ClipUNLSessionImpl() {
		super();
		cookies = Collections.emptyMap();
		fullName = null;
	}

	public ClipUNLSessionImpl(String cookiesStr)
			throws UnsupportedEncodingException {
		this();
		
		cookies = new LinkedHashMap<String, String>();
		for (final String pair : cookiesStr.split("&")) {
			final String[] splitPair = pair.split("=");
			cookies.put(splitPair[0], splitPair[1]);
		}

		getDocument(this, ClipUNLPath.HOME);
	}

	public ClipUNLSessionImpl(String identifier, String password) {
		this();
		login(identifier, password);
	}

	@Override
	public boolean isLoggedIn() {
		if (lastDocument != null) {
			return ClipUNLUtil.getFullName(lastDocument) != null;
		} else {
			return false;
		}
	}

	@Override
	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	@Override
	public Map<String, String> getCookies() {
		return cookies;
	}

	@Override
	public String getFullName() {
		if (fullName == null) {
			fullName = ClipUNLUtil.getFullName(lastDocument);
		}

		return fullName;
	}

	private void login(String identifier, String password) {
		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		data.put(ClipUNLParameterType.IDENTIFIER, identifier);
		data.put(ClipUNLParameterType.PASSWORD, password);

		getDocument(this, ClipUNLPath.HOME, data);
	}
}
