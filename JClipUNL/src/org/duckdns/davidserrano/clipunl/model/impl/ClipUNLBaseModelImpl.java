package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLBaseModel;

public class ClipUNLBaseModelImpl implements ClipUNLBaseModel {
	private ClipUNLSession session;
	
	protected ClipUNLBaseModelImpl(ClipUNLSession session) {
		this.session = session;
	}
	
	public ClipUNLSession getSession() {
		return session;
	}
}
