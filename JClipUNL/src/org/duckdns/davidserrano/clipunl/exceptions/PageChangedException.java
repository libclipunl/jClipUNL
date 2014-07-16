package org.duckdns.davidserrano.clipunl.exceptions;

public class PageChangedException extends ClipUNLException {
	private static final long serialVersionUID = 1134204540547692019L;
	
	private final String url;
	
	public PageChangedException(String url) {
		this.url = url;
	}
	
	@Override
	public String getMessage() {
		return "Page layout has changed on: " + url;
	}
}
