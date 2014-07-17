package org.duckdns.davidserrano.clipunl.model;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;

public class ClipUNLBaseModelImpl implements ClipUNLBaseModel {
	private ClipUNLSession session;
	
	protected ClipUNLBaseModelImpl(ClipUNLSession session) {
		this.session = session;
	}
	
	public ClipUNLSession getSession() {
		return session;
	}
}
