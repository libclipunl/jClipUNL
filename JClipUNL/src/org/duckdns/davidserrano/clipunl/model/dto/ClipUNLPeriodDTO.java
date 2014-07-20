package org.duckdns.davidserrano.clipunl.model.dto;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;

public final class ClipUNLPeriodDTO implements ClipUNLPeriod {
	private static final long serialVersionUID = -7157342961196007935L;
	private ClipUNLPeriod delegate;

	public ClipUNLPeriodDTO(ClipUNLPeriod delegate) {
		this.delegate = delegate;
	}

	public ClipUNLSession getSession() {
		return delegate.getSession();
	}

	public String getPeriod() {
		return delegate.getPeriod();
	}

	public ClipUNLPeriodType getPeriodType() {
		return delegate.getPeriodType();
	}

	@Override
	public ClipUNLAcademicYear getAcademicYear() {
		return delegate.getAcademicYear();
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
		ClipUNLPeriodDTO other = (ClipUNLPeriodDTO) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}
	
}
