package org.duckdns.davidserrano.clipunl.model;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.joda.time.DateTime;

public class ClipUNLExamImpl extends ClipUNLBaseModel implements ClipUNLExam {

	private static final long serialVersionUID = -7719774857248111839L;

	private ClipUNLCurricularUnit curricularUnit;
	private ClipUNLExamSeason examType;
	private DateTime date;

	public ClipUNLExamImpl(ClipUNLSession session) {
		super(session);
	}

	@Override
	public ClipUNLCurricularUnit getCurricularUnit() {
		return curricularUnit;
	}

	public void setCurricularUnit(ClipUNLCurricularUnit curricularUnit) {
		this.curricularUnit = curricularUnit;
	}

	@Override
	public ClipUNLExamSeason getExamType() {
		return examType;
	}

	public void setExamType(ClipUNLExamSeason examType) {
		this.examType = examType;
	}

	@Override
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
}
