package org.duckdns.davidserrano.clipunl.scraper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExam;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExamImpl;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriodImpl;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLExamSeason;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLExamScraper extends ClipUNLScraper {

	private final static String PERIOD_ANCHOR_SELECTOR = "a[href^="
			+ ClipUNLPath.STUDENT_CALENDAR.getPath() + "?]";
	private final static String EXAM_LINES_SELECTOR = "table tr.texto_tabela";

	public static List<ClipUNLPeriod> getPeriods(
			ClipUNLAcademicYear academicYear) {

		final ClipUNLSession session = academicYear.getSession();
		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		final ClipUNLPerson person = academicYear.getPerson();

		data.put(ClipUNLParameterType.ACADEMIC_YEAR, academicYear.getYear());
		data.put(ClipUNLParameterType.STUDENT, person.getId());

		final Document document = getDocument(session,
				ClipUNLPath.STUDENT_CALENDAR, data, Method.GET);

		final Elements lines = document.select(PERIOD_ANCHOR_SELECTOR);

		final List<ClipUNLPeriod> periods = new ArrayList<ClipUNLPeriod>();

		for (final Element line : lines) {
			try {
				Map<ClipUNLParameterType, String> qsMap = ClipUNLUtil
						.splitQueryString(line.attr("href"));
				final String period = qsMap.get(ClipUNLParameterType.PERIOD);
				final ClipUNLPeriodType periodType = ClipUNLPeriodType
						.from(qsMap.get(ClipUNLParameterType.PERIOD_TYPE));

				if (period != null && periodType != null) {
					periods.add(new ClipUNLPeriodImpl(session, period,
							periodType));
				}
			} catch (UnsupportedEncodingException e) {

			}
		}

		return periods;
	}

	public static List<ClipUNLExam> getExams(ClipUNLAcademicYear academicYear,
			ClipUNLPeriod period) {

		final ClipUNLSession session = academicYear.getSession();
		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		final ClipUNLPerson person = academicYear.getPerson();

		data.put(ClipUNLParameterType.ACADEMIC_YEAR, academicYear.getYear());
		data.put(ClipUNLParameterType.STUDENT, person.getId());
		data.put(ClipUNLParameterType.PERIOD, period.getPeriod());
		data.put(ClipUNLParameterType.PERIOD_TYPE, period.getPeriodType()
				.getCode());

		final Document document = getDocument(session,
				ClipUNLPath.STUDENT_CALENDAR, data, Method.GET);

		final Elements lines = document.select(EXAM_LINES_SELECTOR);

		final List<ClipUNLExam> exams = new ArrayList<ClipUNLExam>();

		for (final Element line : lines) {
			final String curricularUnitName = line.child(0).text();
			final String normalSeasonDate = line.child(1).text();
			final String supplementarySeasonDate = line.child(2).text();
			final String specialSeasonDate = line.child(2).text();

			if (normalSeasonDate.length() > 1) {
				final ClipUNLExamImpl exam = new ClipUNLExamImpl(session);
				exam.setCurricularUnitName(curricularUnitName);
				exam.setExamSeason(ClipUNLExamSeason.NORMAL_SEASON);
				exam.setInterval(normalSeasonDate);
				exams.add(exam);
			}

			if (supplementarySeasonDate.length() > 1) {
				final ClipUNLExamImpl exam = new ClipUNLExamImpl(session);
				exam.setCurricularUnitName(curricularUnitName);
				exam.setExamSeason(ClipUNLExamSeason.SUPPLEMENTARY_SEASON);
				exam.setInterval(supplementarySeasonDate);
				exams.add(exam);
			}

			if (specialSeasonDate.length() > 1) {
				final ClipUNLExamImpl exam = new ClipUNLExamImpl(session);
				exam.setCurricularUnitName(curricularUnitName);
				exam.setExamSeason(ClipUNLExamSeason.SPECIAL_SEASON);
				exam.setInterval(specialSeasonDate);
				exams.add(exam);
			}

		}

		return exams;

	}

}
