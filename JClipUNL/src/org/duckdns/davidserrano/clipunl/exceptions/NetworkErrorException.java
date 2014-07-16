package org.duckdns.davidserrano.clipunl.exceptions;

public class NetworkErrorException extends ClipUNLException {
	private static final long serialVersionUID = -1183328181264789689L;
	
	private final String url;
	
	public NetworkErrorException(final String url) {
		this.url = url;
	}
	
	@Override
	public String getMessage() {
		return "Error while trying to get URL: " + url;
	}
}
