package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;

public interface ClipUNLPerson extends ClipUNLBaseModel, Serializable {

	public abstract String getRole();

	public abstract String getURL();

	public abstract String getDescription();

	public abstract String getId();

	public abstract List<ClipUNLAcademicYear> getAcademicYears();

}