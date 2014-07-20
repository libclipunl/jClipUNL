package org.duckdns.davidserrano.clipunl.model.dto;

import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public final class ClipUNLCurricularUnitDTO implements ClipUNLCurricularUnit {
	private static final long serialVersionUID = 9024654137183885087L;
	private ClipUNLCurricularUnit delegate;

	public ClipUNLCurricularUnitDTO(ClipUNLCurricularUnit delegate) {
		this.delegate = delegate;
	}

	public ClipUNLSession getSession() {
		return delegate.getSession();
	}

	public ClipUNLAcademicYear getAcademicYear() {
		return delegate.getAcademicYear();
	}

	public String getUrl() {
		return delegate.getUrl();
	}

	public String getName() {
		return delegate.getName();
	}

	public String getId() {
		return delegate.getId();
	}

	public ClipUNLPeriod getPeriod() {
		return delegate.getPeriod();
	}

	public List<ClipUNLDocument> getDocuments() {
		return delegate.getDocuments();
	}

	public List<ClipUNLDocument> getDocuments(ClipUNLDocumentType documentType) {
		return delegate.getDocuments(documentType);
	}

	public Map<ClipUNLDocumentType, List<ClipUNLDocument>> getDocumentsByType() {
		return delegate.getDocumentsByType();
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
		ClipUNLCurricularUnitDTO other = (ClipUNLCurricularUnitDTO) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}

}
