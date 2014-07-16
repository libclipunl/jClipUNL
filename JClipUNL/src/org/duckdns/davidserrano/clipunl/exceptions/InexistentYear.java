package org.duckdns.davidserrano.clipunl.exceptions;

public class InexistentYear extends ClipUNLException {
	private static final long serialVersionUID = -4574373850440497281L;

	private int year;

	public InexistentYear(final int year) {
		this.year = year;
	}

	@Override
	public String getMessage() {
		return "Inexistent year: " + year;
	}

}
