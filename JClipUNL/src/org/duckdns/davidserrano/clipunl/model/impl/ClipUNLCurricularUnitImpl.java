package org.duckdns.davidserrano.clipunl.model.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLDocumentScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;

public class ClipUNLCurricularUnitImpl extends ClipUNLBaseModelImpl implements
		ClipUNLCurricularUnit {

	private static final long serialVersionUID = 4968251116633463502L;

	private ClipUNLAcademicYear academicYear;
	private String url;
	private String name;
	private String id;
	private ClipUNLPeriod period;

	private Map<ClipUNLDocumentType, List<ClipUNLDocument>> documentsByType;

	public ClipUNLCurricularUnitImpl(ClipUNLSession session) {
		super(session);
	}

	@Override
	public ClipUNLAcademicYear getAcademicYear() {
		return academicYear;
	}

	@Override
	public String getUrl() {
		return ClipUNLConstants.CLIP_SERVER + url;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public ClipUNLPeriod getPeriod() {
		return period;
	}

	@Override
	public List<ClipUNLDocument> getDocuments() {
		final Map<ClipUNLDocumentType, List<ClipUNLDocument>> documentsByType = getDocumentsByType();
		final List<ClipUNLDocument> documents = new ArrayList<ClipUNLDocument>();

		for (final Entry<ClipUNLDocumentType, List<ClipUNLDocument>> entry : documentsByType
				.entrySet()) {

			documents.addAll(entry.getValue());
		}

		return documents;
	}

	public void setAcademicYear(ClipUNLAcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPeriod(ClipUNLPeriod period) {
		this.period = period;
	}

	@Override
	public List<ClipUNLDocument> getDocuments(ClipUNLDocumentType documentType) {
		if (documentsByType == null) {
			documentsByType = new LinkedHashMap<ClipUNLDocumentType, List<ClipUNLDocument>>(
					ClipUNLDocumentType.values().length);
		}

		if (!documentsByType.containsKey(documentType)) {
			documentsByType.put(documentType,
					ClipUNLDocumentScraper.getDocuments(this, documentType));
		}

		return documentsByType.get(documentType);
	}

	@Override
	public Map<ClipUNLDocumentType, List<ClipUNLDocument>> getDocumentsByType() {
		if (documentsByType == null) {
			documentsByType = new LinkedHashMap<ClipUNLDocumentType, List<ClipUNLDocument>>(
					ClipUNLDocumentType.values().length);
		}

		for (final ClipUNLDocumentType documentType : ClipUNLDocumentType
				.values()) {
			if (!documentsByType.containsKey(documentType)) {
				documentsByType
						.put(documentType, ClipUNLDocumentScraper.getDocuments(
								this, documentType));
			}
		}

		return documentsByType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((academicYear == null) ? 0 : academicYear.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		ClipUNLCurricularUnitImpl other = (ClipUNLCurricularUnitImpl) obj;
		if (academicYear == null) {
			if (other.academicYear != null)
				return false;
		} else if (!academicYear.equals(other.academicYear))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}

}
