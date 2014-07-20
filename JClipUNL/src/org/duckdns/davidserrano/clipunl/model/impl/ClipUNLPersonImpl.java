package org.duckdns.davidserrano.clipunl.model.impl;

import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLAcademicYearScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;

public class ClipUNLPersonImpl extends ClipUNLBaseModelImpl implements
		ClipUNLPerson {
	private static final long serialVersionUID = -6852564565366259034L;

	private String role;
	private String url;
	private String description;
	private String id;

	private List<ClipUNLAcademicYear> years;

	public ClipUNLPersonImpl(final ClipUNLSession session) {
		super(session);
	}

	@Override
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getURL() {
		return ClipUNLConstants.CLIP_SERVER + url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<ClipUNLAcademicYear> getAcademicYears() {
		if (years == null) {
			years = ClipUNLAcademicYearScraper.getAcademicYears(this);
		}

		return years;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClipUNLPersonImpl other = (ClipUNLPersonImpl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

}
