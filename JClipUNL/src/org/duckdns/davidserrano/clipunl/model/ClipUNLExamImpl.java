package org.duckdns.davidserrano.clipunl.model;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;

public class ClipUNLExamImpl extends ClipUNLBaseModelImpl implements
		ClipUNLExam {

	private static final long serialVersionUID = -7719774857248111839L;

	private String curricularUnitName;
	private ClipUNLExamSeason examSeason;
	private Interval interval;

	public ClipUNLExamImpl(ClipUNLSession session) {
		super(session);
	}

	@Override
	public String getCurricularUnitName() {
		return curricularUnitName;
	}

	public void setCurricularUnitName(String curricularUnit) {
		this.curricularUnitName = curricularUnit;
	}

	@Override
	public ClipUNLExamSeason getExamSeason() {
		return examSeason;
	}

	public void setExamSeason(ClipUNLExamSeason examSeason) {
		this.examSeason = examSeason;
	}

	@Override
	public Interval getInterval() {
		return interval;
	}

	public void setInterval(String dateInterval) {
		String[] pieces = dateInterval.split(" ");
		String date = pieces[0];
		String[] timePieces = pieces[1].split("-");
		
		timePieces[0] = timePieces[0].replaceAll("\u00a0","");
		timePieces[1] = timePieces[1].replaceAll("\u00a0","");

		DateTime start = DateTimeFormat.forPattern(
				ClipUNLConstants.CLIP_DATETIME_FORMAT).parseDateTime(
				date + " " + timePieces[0]);

		DateTime end = DateTimeFormat.forPattern(
				ClipUNLConstants.CLIP_DATETIME_FORMAT).parseDateTime(
				date + " " + timePieces[1]);

		interval = new Interval(start, end);
	}
}
