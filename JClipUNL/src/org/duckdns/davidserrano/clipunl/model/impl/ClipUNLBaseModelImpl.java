package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLBaseModel;

public class ClipUNLBaseModelImpl implements ClipUNLBaseModel {
	private ClipUNLSession session;

	protected ClipUNLBaseModelImpl(ClipUNLSession session) {
		this.session = session;
	}

	public ClipUNLSession getSession() {
		return session;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((session == null) ? 0 : session.hashCode());
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
		ClipUNLBaseModelImpl other = (ClipUNLBaseModelImpl) obj;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}
}
