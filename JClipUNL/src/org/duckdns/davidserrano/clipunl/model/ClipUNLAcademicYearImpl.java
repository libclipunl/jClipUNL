package org.duckdns.davidserrano.clipunl.model;

import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLCurricularUnitScraper;

public class ClipUNLAcademicYearImpl extends ClipUNLBaseModel implements
		ClipUNLAcademicYear {

	private static final long serialVersionUID = 8880192762897160163L;

	private String year;
	private String url;
	private String description;
	private ClipUNLPerson person;

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

	public ClipUNLPerson getPerson() {
		return person;
	}

	public void setPerson(ClipUNLPerson person) {
		this.person = person;
	}

	@Override
	public List<ClipUNLCurricularUnit> getCurricularUnits() {
		return ClipUNLCurricularUnitScraper.getCurricularUnits(getSession(), this);
	}

}
