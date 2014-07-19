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

}
