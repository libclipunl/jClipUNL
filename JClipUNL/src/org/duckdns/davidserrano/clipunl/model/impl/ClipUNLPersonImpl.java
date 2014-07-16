package org.duckdns.davidserrano.clipunl.model.impl;

import java.io.Serializable;
import java.util.List;

import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;

public class ClipUNLPersonImpl implements Serializable, ClipUNLPerson {
	private static final long serialVersionUID = -6852564565366259034L;
	
	public String role;
	public String url;
	public String id;
	public List<Integer> years;

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLPerson#getRole()
	 */
	@Override
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLPerson#getUrl()
	 */
	@Override
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLPerson#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLPerson#getYears()
	 */
	@Override
	public List<Integer> getYears() {
		return years;
	}

	public void setYears(List<Integer> years) {
		this.years = years;
	}

}
