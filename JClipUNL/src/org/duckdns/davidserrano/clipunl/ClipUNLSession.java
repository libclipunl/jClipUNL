package org.duckdns.davidserrano.clipunl;

import java.util.Map;

public interface ClipUNLSession {

	public abstract boolean isLoggedIn();

	public abstract void setCookies(Map<String, String> cookies);

	public abstract Map<String, String> getCookies();

	public abstract String getFullName();

}