package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.joda.time.Interval;

public interface ClipUNLExam extends ClipUNLBaseModel, Serializable {

	public abstract String getCurricularUnitName();

	public abstract ClipUNLExamSeason getExamSeason();

	public abstract Interval getInterval();

	public abstract List<String> getLocations();

	public abstract ClipUNLAcademicYear getAcademicYear();

	public abstract String getURL();
	
	public abstract String getId();

	public abstract ClipUNLPeriod getPeriod();
}