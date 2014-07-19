package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;

public interface ClipUNLSession extends Serializable {

	public abstract boolean isLoggedIn();

	public abstract void setCookies(Map<String, String> cookies);

	public abstract Map<String, String> getCookies();

	public abstract String getFullName();

	public abstract List<ClipUNLPerson> getPeople();
}