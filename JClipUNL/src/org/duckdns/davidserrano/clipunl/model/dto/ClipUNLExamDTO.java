package org.duckdns.davidserrano.clipunl.model.dto;

import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExam;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.joda.time.Interval;

public final class ClipUNLExamDTO implements ClipUNLExam {
	private static final long serialVersionUID = 812228219025091458L;
	private ClipUNLExam delegate;

	public ClipUNLExamDTO(ClipUNLExam delegate) {
		this.delegate = delegate;
	}

	public ClipUNLSession getSession() {
		return delegate.getSession();
	}

	public String getCurricularUnitName() {
		return delegate.getCurricularUnitName();
	}

	public ClipUNLExamSeason getExamSeason() {
		return delegate.getExamSeason();
	}

	public Interval getInterval() {
		return delegate.getInterval();
	}

	public List<String> getLocations() {
		return delegate.getLocations();
	}

	public ClipUNLAcademicYear getAcademicYear() {
		return delegate.getAcademicYear();
	}

	public String getURL() {
		return delegate.getURL();
	}

	public String getId() {
		return delegate.getId();
	}

	public ClipUNLPeriod getPeriod() {
		return delegate.getPeriod();
	}

}
