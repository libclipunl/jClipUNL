package org.duckdns.davidserrano.clipunl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class ClipUNLSessionFactory implements Serializable {
	private static final long serialVersionUID = -3802958103464356532L;

	public static ClipUNLSession getSession(String identifier, final String password) {
		return new ClipUNLSessionImpl(identifier, password);
	}
	
	public static ClipUNLSession getSession(String cookie) throws UnsupportedEncodingException {
		return new ClipUNLSessionImpl(cookie);
	}
}
