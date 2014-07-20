package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLPeopleScraper;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;

public class ClipUNLSessionImpl extends ClipUNLScraper implements Serializable,
		ClipUNLSession {
	private static final long serialVersionUID = 1018884267769939415L;
	private Map<String, String> cookies;

	private String fullName;

	private List<ClipUNLPerson> people;

	private ClipUNLSessionImpl() {
		super();
		cookies = Collections.emptyMap();
		fullName = null;
		people = null;
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

	@Override
	public List<ClipUNLPerson> getPeople() {
		if (people == null) {
			people = ClipUNLPeopleScraper.getPeople(this);
		}

		return people;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cookies == null) ? 0 : cookies.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClipUNLSessionImpl other = (ClipUNLSessionImpl) obj;
		if (cookies == null) {
			if (other.cookies != null)
				return false;
		} else if (!cookies.equals(other.cookies))
			return false;
		return true;
	}

	@Override
	public String getCookieString() {
		String cookieStr = "";

		if (cookies != null) {
			for (final Entry<String, String> entry : cookies.entrySet()) {
				cookieStr += entry.getKey() + "=" + entry.getValue() + "; ";
			}

			if (!cookieStr.isEmpty()) {
				cookieStr = cookieStr.substring(0, cookieStr.length() - 2);
			}
		}

		return cookieStr;
	}
}
