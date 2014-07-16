package org.duckdns.davidserrano.clipunl.model.impl;

import java.io.Serializable;
import java.util.Date;

import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public class ClipUNLDocumentImpl implements Serializable, ClipUNLDocument {
	private static final long serialVersionUID = -8001382898325022999L;

	private String oid;
	private ClipUNLCurricularUnit curricularUnit;
	private String name;
	private String url;
	private ClipUNLDocumentType documentType;
	private Date date;
	private long size;
	private String teacher;

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getOid()
	 */
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

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getUrl()
	 */
	@Override
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getDocumentType()
	 */
	@Override
	public ClipUNLDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(ClipUNLDocumentType documentType) {
		this.documentType = documentType;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getDate()
	 */
	@Override
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getSize()
	 */
	@Override
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLDocument#getTeacher()
	 */
	@Override
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
