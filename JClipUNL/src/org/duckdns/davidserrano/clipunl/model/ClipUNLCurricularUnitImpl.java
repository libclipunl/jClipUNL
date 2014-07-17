package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public class ClipUNLCurricularUnitImpl extends ClipUNLBaseModel implements
		Serializable, ClipUNLCurricularUnit {

	private static final long serialVersionUID = 4968251116633463502L;

	private ClipUNLPerson person;
	private String url;
	private String name;

	private long id;
	private int year;
	private int period;
	private String periodType;

	private Map<String, ClipUNLDocument> documents;
	private List<ClipUNLDocumentType> documentTypes;

	public ClipUNLCurricularUnitImpl(ClipUNLSession session) {
		super(session);
	}

	public ClipUNLPerson getPerson() {
		return person;
	}

	public void setPerson(ClipUNLPerson person) {
		this.person = person;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public Map<String, ClipUNLDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(Map<String, ClipUNLDocument> documents) {
		this.documents = documents;
	}

	public List<ClipUNLDocumentType> getDocumentTypes() {
		return documentTypes;
	}

	public void setDocumentTypes(List<ClipUNLDocumentType> documentTypes) {
		this.documentTypes = documentTypes;
	}

}
