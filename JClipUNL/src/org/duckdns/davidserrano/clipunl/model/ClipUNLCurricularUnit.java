package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;

public interface ClipUNLCurricularUnit extends Serializable {

	public abstract ClipUNLAcademicYear getAcademicYear();

	public abstract String getUrl();

	public abstract String getName();

	public abstract String getId();

	public abstract ClipUNLPeriod getPeriod();

	public abstract List<ClipUNLDocument> getDocuments();

}