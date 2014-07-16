package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;

public abstract class ClipUNLBaseModel {
	private ClipUNLSession session;
	
	public ClipUNLBaseModel(ClipUNLSession session) {
		this.session = session;
	}
	
	protected ClipUNLSession getSession() {
		return session;
	}
}
