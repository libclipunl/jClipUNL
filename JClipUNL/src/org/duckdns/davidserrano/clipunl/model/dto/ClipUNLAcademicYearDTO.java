package org.duckdns.davidserrano.clipunl.model.dto;

import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExam;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;

public final class ClipUNLAcademicYearDTO implements ClipUNLAcademicYear {
	private static final long serialVersionUID = 8646216242450540596L;
	private ClipUNLAcademicYear delegate;

	public ClipUNLAcademicYearDTO(ClipUNLAcademicYear delegate) {
		this.delegate = delegate;
	}

	public ClipUNLSession getSession() {
		return delegate.getSession();
	}

	public String getYear() {
		return delegate.getYear();
	}

	public String getURL() {
		return delegate.getURL();
	}

	public String getDescription() {
		return delegate.getDescription();
	}

	public List<ClipUNLCurricularUnit> getCurricularUnits() {
		return delegate.getCurricularUnits();
	}

	public ClipUNLPerson getPerson() {
		return delegate.getPerson();
	}

	public List<ClipUNLExam> getExams() {
		return delegate.getExams();
	}

	public List<ClipUNLExam> getExams(ClipUNLPeriod period) {
		return delegate.getExams(period);
	}

	public Map<ClipUNLPeriod, List<ClipUNLExam>> getExamsByPeriod() {
		return delegate.getExamsByPeriod();
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
		ClipUNLAcademicYearDTO other = (ClipUNLAcademicYearDTO) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}
	
	
}
