package org.duckdns.davidserrano.clipunl.model.impl;

import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLEvaluation;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.joda.time.DateTime;

public class ClipUNLEvaluationImpl implements ClipUNLEvaluation {
	private static final long serialVersionUID = -7719774857248111839L;
	
	private ClipUNLCurricularUnit curricularUnit;
	private ClipUNLExamSeason examType;
	private DateTime date;

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLEvaluation#getCurricularUnit()
	 */
	@Override
	public ClipUNLCurricularUnit getCurricularUnit() {
		return curricularUnit;
	}

	public void setCurricularUnit(ClipUNLCurricularUnit curricularUnit) {
		this.curricularUnit = curricularUnit;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLEvaluation#getExamType()
	 */
	@Override
	public ClipUNLExamSeason getExamType() {
		return examType;
	}

	public void setExamType(ClipUNLExamSeason examType) {
		this.examType = examType;
	}

	/* (non-Javadoc)
	 * @see org.duckdns.davidserrano.clipunl.model.impl.ClipUNLEvaluation#getDate()
	 */
	@Override
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
}
