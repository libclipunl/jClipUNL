package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;

public class ClipUNL implements Serializable {
	private static final long serialVersionUID = -3802958103464356532L;

	public static ClipUNLSession getSession(String identifier, final String password) {
		return new ClipUNLSession(identifier, password);
	}
}
