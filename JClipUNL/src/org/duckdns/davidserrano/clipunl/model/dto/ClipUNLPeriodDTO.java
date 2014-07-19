package org.duckdns.davidserrano.clipunl.model.dto;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
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

}
