package org.duckdns.davidserrano.clipunl.model.impl;

import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.scrapper.ClipUNLAcademicYearScrapper;

public class ClipUNLPersonImpl extends ClipUNLBaseModel implements
		ClipUNLPerson {
	private static final long serialVersionUID = -6852564565366259034L;

	private String role;
	private String url;
	private String description;
	private String id;

	private List<ClipUNLAcademicYear> years;

	public ClipUNLPersonImpl(final ClipUNLSession session) {
		super(session);
	}

	@Override
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<ClipUNLAcademicYear> getAcademicYears() {
		if (years == null) {
			years = ClipUNLAcademicYearScrapper.getAcademicYears(getSession(),
					this);
		}

		return years;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
