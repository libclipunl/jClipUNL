package org.duckdns.davidserrano.clipunl.model;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;

public class ClipUNLBaseModel {
	private ClipUNLSession session;
	
	public ClipUNLBaseModel(ClipUNLSession session) {
		this.session = session;
	}
	
	protected ClipUNLSession getSession() {
		return session;
	}
}
