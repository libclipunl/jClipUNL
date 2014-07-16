package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;

public interface ClipUNLCurricularUnit extends Serializable {

	public abstract ClipUNLPerson getPerson();

	public abstract String getUrl();

	public abstract String getName();

	public abstract long getId();

	public abstract int getYear();

	public abstract int getPeriod();

	public abstract String getPeriodType();

	public abstract Map<String, ClipUNLDocument> getDocuments();

	public abstract List<ClipUNLDocumentType> getDocumentTypes();

}