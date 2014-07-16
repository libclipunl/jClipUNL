package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.joda.time.DateTime;

public interface ClipUNLEvaluation extends Serializable {

	public abstract ClipUNLCurricularUnit getCurricularUnit();

	public abstract ClipUNLExamSeason getExamType();

	public abstract DateTime getDate();

}