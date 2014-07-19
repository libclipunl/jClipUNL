package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;

public class ClipUNLDocumentImpl extends ClipUNLBaseModelImpl implements
		ClipUNLDocument {

	private static final long serialVersionUID = -8001382898325022999L;

	private String oid;
	private ClipUNLCurricularUnit curricularUnit;
	private String name;
	private String url;
	private ClipUNLDocumentType documentType;
	private String date;
	private String size;
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
		return ClipUNLConstants.CLIP_SERVER + url;
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
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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
