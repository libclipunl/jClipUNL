package org.duckdns.davidserrano.clipunl.exceptions;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;

public class PageChangedException extends ClipUNLException {
	private static final long serialVersionUID = 1134204540547692019L;

	private final ClipUNLPath path;

	public PageChangedException(ClipUNLPath path) {
		this.path = path;
	}

	@Override
	public String getMessage() {
		return "Page layout has changed on: " + path.getURL();
	}
}
