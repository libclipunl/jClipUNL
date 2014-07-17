package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;

import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;

public interface ClipUNLPeriod extends Serializable {
	abstract public String getPeriod();

	abstract public ClipUNLPeriodType getPeriodType();
}
