package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;

public interface ClipUNLPeriod extends ClipUNLBaseModel, Serializable {
	abstract public String getPeriod();

	abstract public ClipUNLAcademicYear getAcademicYear();

	abstract public ClipUNLPeriodType getPeriodType();

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();
}
