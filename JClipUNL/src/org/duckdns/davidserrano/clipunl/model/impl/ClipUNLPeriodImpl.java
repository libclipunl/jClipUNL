package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;

public class ClipUNLPeriodImpl extends ClipUNLBaseModelImpl implements
		ClipUNLPeriod {
	private static final long serialVersionUID = -4926884020349768719L;

	private String period;
	private ClipUNLPeriodType periodType;
	private ClipUNLAcademicYear academicYear;

	public ClipUNLPeriodImpl(ClipUNLSession session) {
		super(session);
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setPeriodType(ClipUNLPeriodType periodType) {
		this.periodType = periodType;
	}

	public void setAcademicYear(ClipUNLAcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public String getPeriod() {
		return period;
	}

	@Override
	public ClipUNLPeriodType getPeriodType() {
		return periodType;
	}

	@Override
	public ClipUNLAcademicYear getAcademicYear() {
		return academicYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((academicYear == null) ? 0 : academicYear.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result
				+ ((periodType == null) ? 0 : periodType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClipUNLPeriodImpl other = (ClipUNLPeriodImpl) obj;
		if (academicYear == null) {
			if (other.academicYear != null)
				return false;
		} else if (!academicYear.equals(other.academicYear))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (periodType != other.periodType)
			return false;
		return true;
	}

}
