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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((delegate == null) ? 0 : delegate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClipUNLExamDTO other = (ClipUNLExamDTO) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}

}
