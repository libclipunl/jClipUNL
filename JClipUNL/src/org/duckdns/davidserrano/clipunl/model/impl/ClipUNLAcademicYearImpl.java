package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;

public class ClipUNLAcademicYearImpl extends ClipUNLBaseModel implements
		ClipUNLAcademicYear {
	private static final long serialVersionUID = 8880192762897160163L;
	
	private String year;
	private String url;
	private String description;

	public ClipUNLAcademicYearImpl(ClipUNLSession session) {
		super(session);
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
