package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.Date;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public class ClipUNLDocumentImpl extends ClipUNLBaseModel implements
		Serializable, ClipUNLDocument {

	private static final long serialVersionUID = -8001382898325022999L;

	private String oid;
	private ClipUNLCurricularUnit curricularUnit;
	private String name;
	private String url;
	private ClipUNLDocumentType documentType;
	private Date date;
	private long size;
	private String teacher;

	public ClipUNLDocumentImpl(ClipUNLSession session) {
		super(session);
	}

	@Override
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@Override
	public ClipUNLCurricularUnit getCurricularUnit() {
		return curricularUnit;
	}

	public void setCurricularUnit(ClipUNLCurricularUnit curricularUnit) {
		this.curricularUnit = curricularUnit;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	@Override
	public ClipUNLDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(ClipUNLDocumentType documentType) {
		this.documentType = documentType;
	}

	@Override
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
