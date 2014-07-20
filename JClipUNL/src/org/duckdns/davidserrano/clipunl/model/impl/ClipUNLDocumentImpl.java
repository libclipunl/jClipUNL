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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((curricularUnit == null) ? 0 : curricularUnit.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((documentType == null) ? 0 : documentType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		ClipUNLDocumentImpl other = (ClipUNLDocumentImpl) obj;
		if (curricularUnit == null) {
			if (other.curricularUnit != null)
				return false;
		} else if (!curricularUnit.equals(other.curricularUnit))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (documentType != other.documentType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

}
