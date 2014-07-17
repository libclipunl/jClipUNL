package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.scraper.ClipUNLScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;

public class ClipUNLSessionImpl extends ClipUNLScraper implements
		Serializable, ClipUNLSession {
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
		cookies = ClipUNLUtil.splitQueryString(cookiesStr);

		getDocument(this, "");
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
		final Map<String, String> data = new HashMap<>();

		data.put(ClipUNLConstants.CLIP_PARAM_IDENTIFIER, identifier);
		data.put(ClipUNLConstants.CLIP_PARAM_PASSWORD, password);

		getDocument(this, ClipUNLConstants.CLIP_LOGIN_PATH, data);
	}
}
