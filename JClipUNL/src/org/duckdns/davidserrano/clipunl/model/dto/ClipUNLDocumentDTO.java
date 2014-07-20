package org.duckdns.davidserrano.clipunl.model.dto;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public final class ClipUNLDocumentDTO implements ClipUNLDocument {
	private static final long serialVersionUID = 3592120721119238578L;
	private ClipUNLDocument delegate;

	public ClipUNLDocumentDTO(ClipUNLDocument delegate) {
		this.delegate = delegate;
	}

	public ClipUNLSession getSession() {
		return delegate.getSession();
	}

	public String getOid() {
		return delegate.getOid();
	}

	public ClipUNLCurricularUnit getCurricularUnit() {
		return delegate.getCurricularUnit();
	}

	public String getName() {
		return delegate.getName();
	}

	public String getURL() {
		return delegate.getURL();
	}

	public ClipUNLDocumentType getDocumentType() {
		return delegate.getDocumentType();
	}

	public String getDate() {
		return delegate.getDate();
	}

	public String getSize() {
		return delegate.getSize();
	}

	public String getTeacher() {
		return delegate.getTeacher();
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
		ClipUNLDocumentDTO other = (ClipUNLDocumentDTO) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}

}
