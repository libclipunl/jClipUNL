package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.Date;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public interface ClipUNLDocument extends Serializable {

	public abstract String getOid();

	public abstract ClipUNLCurricularUnit getCurricularUnit();

	public abstract String getName();

	public abstract String getUrl();

	public abstract ClipUNLDocumentType getDocumentType();

	public abstract Date getDate();

	public abstract long getSize();

	public abstract String getTeacher();

}