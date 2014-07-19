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

}
