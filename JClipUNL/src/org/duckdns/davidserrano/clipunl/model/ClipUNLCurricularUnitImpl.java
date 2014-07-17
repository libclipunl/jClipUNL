package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;

public class ClipUNLCurricularUnitImpl extends ClipUNLBaseModel implements
		Serializable, ClipUNLCurricularUnit {

	private static final long serialVersionUID = 4968251116633463502L;

	private ClipUNLAcademicYear academicYear;
	private String url;
	private String name;
	private String id;
	private ClipUNLPeriod period;

	public ClipUNLCurricularUnitImpl(ClipUNLSession session) {
		super(session);
	}

	@Override
	public ClipUNLAcademicYear getAcademicYear() {
		return academicYear;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public ClipUNLPeriod getPeriod() {
		return period;
	}

	@Override
	public List<ClipUNLDocument> getDocuments() {
		// TODO me
		return null;
	}

	public void setAcademicYear(ClipUNLAcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPeriod(ClipUNLPeriod period) {
		this.period = period;
	}
}
