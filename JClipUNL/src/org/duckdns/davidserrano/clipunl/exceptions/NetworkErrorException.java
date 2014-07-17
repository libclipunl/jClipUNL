package org.duckdns.davidserrano.clipunl.exceptions;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;

public class NetworkErrorException extends ClipUNLException {
	private static final long serialVersionUID = -1183328181264789689L;

	private final String url;

	public NetworkErrorException(final String url) {
		this.url = url;
	}

	public NetworkErrorException(final ClipUNLPath path) {
		this.url = path.getURL();
	}

	@Override
	public String getMessage() {
		return "Error while trying to get URL: " + url;
	}
}
