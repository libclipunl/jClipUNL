package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.joda.time.Interval;

public interface ClipUNLExam extends ClipUNLBaseModel, Serializable {

	public abstract String getCurricularUnitName();

	public abstract ClipUNLExamSeason getExamSeason();

	public abstract Interval getInterval();

}