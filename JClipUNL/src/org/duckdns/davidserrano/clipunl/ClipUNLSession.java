package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.scrapper.ClipUNLScrapper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;

public class ClipUNLSession extends ClipUNLScrapper implements Serializable {
	private static final long serialVersionUID = 1018884267769939415L;
	private Map<String, String> cookies;

	private String fullName;

	private ClipUNLSession() {
		super();
		cookies = Collections.emptyMap();
		fullName = null;
	}

	public ClipUNLSession(String identifier, String password) {
		this();
		login(identifier, password);
	}

	public boolean isLoggedIn() {
		if (lastDocument != null) {
			return ClipUNLUtil.getFullName(lastDocument) != null;
		} else {
			return false;
		}
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

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
