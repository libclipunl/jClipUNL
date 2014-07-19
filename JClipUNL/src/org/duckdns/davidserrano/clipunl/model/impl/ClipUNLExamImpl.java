package org.duckdns.davidserrano.clipunl.model.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExam;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLExamScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;

public class ClipUNLExamImpl extends ClipUNLBaseModelImpl implements
		ClipUNLExam {

	private static final long serialVersionUID = -7719774857248111839L;

	private ClipUNLAcademicYear academicYear;
	private ClipUNLPeriod period;
	private String curricularUnitName;
	private ClipUNLExamSeason examSeason;
	private Interval interval;
	private List<String> locations;
	private String url;
	private String id;

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

		timePieces[0] = timePieces[0].replaceAll("\u00a0", "");
		timePieces[1] = timePieces[1].replaceAll("\u00a0", "");

		DateTime start = DateTimeFormat.forPattern(
				ClipUNLConstants.CLIP_DATETIME_FORMAT).parseDateTime(
				date + " " + timePieces[0]);

		DateTime end = DateTimeFormat.forPattern(
				ClipUNLConstants.CLIP_DATETIME_FORMAT).parseDateTime(
				date + " " + timePieces[1]);

		interval = new Interval(start, end);
	}

	@Override
	public List<String> getLocations() {
		if (locations == null) {
			locations = ClipUNLExamScraper.getLocations(this);
		}

		return locations;
	}

	public void setAcademicYear(ClipUNLAcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public ClipUNLAcademicYear getAcademicYear() {
		return academicYear;
	}

	@Override
	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
		
		try {
			final Map<ClipUNLParameterType, String> qsMap = ClipUNLUtil.splitQueryString(url);
		
			id = qsMap.get(ClipUNLParameterType.DETAILS);
		} catch (UnsupportedEncodingException e) {
		}
	}

	@Override
	public ClipUNLPeriod getPeriod() {
		return period;
	}

	public void setPeriod(ClipUNLPeriod period) {
		this.period = period;
	}
	
	@Override
	public String getId() {
		return id;
	}
}
