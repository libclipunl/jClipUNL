package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public interface ClipUNLDocument extends ClipUNLBaseModel, Serializable {

	public abstract String getOid();

	public abstract ClipUNLCurricularUnit getCurricularUnit();

	public abstract String getName();

	public abstract String getURL();

	public abstract ClipUNLDocumentType getDocumentType();

	public abstract String getDate();

	public abstract String getSize();

	public abstract String getTeacher();

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

}