package org.duckdns.davidserrano.clipunl.model;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;

public interface ClipUNLBaseModel {

	public abstract ClipUNLSession getSession();

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

}
