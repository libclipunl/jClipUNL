package org.duckdns.davidserrano.clipunl.model.dto;

import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;

public final class ClipUNLPersonDTO implements ClipUNLPerson {
	private static final long serialVersionUID = 8973629017248186627L;
	private ClipUNLPerson delegate;

	public ClipUNLPersonDTO(ClipUNLPerson delegate) {
		this.delegate = delegate;
	}

	public ClipUNLSession getSession() {
		return delegate.getSession();
	}

	public String getRole() {
		return delegate.getRole();
	}

	public String getURL() {
		return delegate.getURL();
	}

	public String getDescription() {
		return delegate.getDescription();
	}

	public String getId() {
		return delegate.getId();
	}

	public List<ClipUNLAcademicYear> getAcademicYears() {
		return delegate.getAcademicYears();
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
		ClipUNLPersonDTO other = (ClipUNLPersonDTO) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}

}
