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
	private boolean isLoggedIn;

	private ClipUNLSession() {
		super();
		cookies = Collections.emptyMap();
		fullName = null;
		isLoggedIn = false;
	}

	public ClipUNLSession(String identifier, String password) {
		this();
		isLoggedIn = login(identifier, password);
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public String getFullName() {
		return fullName;
	}

	private boolean login(String identifier, String password) {
		final Map<String, String> data = new HashMap<>();
		
		data.put(ClipUNLConstants.CLIP_QS_PARAM_IDENTIFIER, identifier);
		data.put(ClipUNLConstants.CLIP_QS_PARAM_PASSWORD, password);

		lastDocument = getDocument(this, ClipUNLConstants.CLIP_LOGIN, data);

		fullName = ClipUNLUtil.getFullName(lastDocument);
		
		final boolean isLoggedIn;
		if (fullName != null) {
			isLoggedIn = true;
		} else {
			isLoggedIn = false;
		}

		return isLoggedIn;
	}
}
