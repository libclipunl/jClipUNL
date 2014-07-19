package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;

public class ClipUNLPeriodImpl extends ClipUNLBaseModelImpl implements
		ClipUNLPeriod {
	private static final long serialVersionUID = -4926884020349768719L;

	private String period;
	private ClipUNLPeriodType periodType;

	public ClipUNLPeriodImpl(ClipUNLSession session, String period,
			ClipUNLPeriodType periodType) {
		super(session);
		this.period = period;
		this.periodType = periodType;
	}

	@Override
	public String getPeriod() {
		return period;
	}

	@Override
	public ClipUNLPeriodType getPeriodType() {
		return periodType;
	}

}
