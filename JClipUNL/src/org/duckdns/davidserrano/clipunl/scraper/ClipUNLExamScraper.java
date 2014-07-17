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
	private final static String DETAIL_LINK_SELECTOR = "a:has(img[title=detalhes])";
	private final static String LOCATIONS_LIST_ITEM_SELECTOR = "tr.texto_tabela ul li";

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
			final Element normalSeasonDate = line.child(1);
			final Element supplementarySeasonDate = line.child(2);
			final Element specialSeasonDate = line.child(2);

			if (normalSeasonDate.text().length() > 1) {
				final ClipUNLExamImpl exam = new ClipUNLExamImpl(session);
				final Elements anchor = normalSeasonDate
						.select(DETAIL_LINK_SELECTOR);

				exam.setAcademicYear(academicYear);
				exam.setCurricularUnitName(curricularUnitName);
				exam.setExamSeason(ClipUNLExamSeason.NORMAL_SEASON);
				exam.setInterval(normalSeasonDate.text());
				exam.setPeriod(period);
				exam.setURL(anchor.attr("href"));
				exams.add(exam);
			}

			if (supplementarySeasonDate.text().length() > 1) {
				final ClipUNLExamImpl exam = new ClipUNLExamImpl(session);
				final Elements anchor = supplementarySeasonDate
						.select(DETAIL_LINK_SELECTOR);

				exam.setAcademicYear(academicYear);
				exam.setCurricularUnitName(curricularUnitName);
				exam.setExamSeason(ClipUNLExamSeason.SUPPLEMENTARY_SEASON);
				exam.setInterval(supplementarySeasonDate.text());
				exam.setPeriod(period);
				exam.setURL(anchor.attr("href"));
				exams.add(exam);
			}

			if (specialSeasonDate.text().length() > 1) {
				final ClipUNLExamImpl exam = new ClipUNLExamImpl(session);
				final Elements anchor = supplementarySeasonDate
						.select(DETAIL_LINK_SELECTOR);

				exam.setAcademicYear(academicYear);
				exam.setCurricularUnitName(curricularUnitName);
				exam.setExamSeason(ClipUNLExamSeason.SPECIAL_SEASON);
				exam.setInterval(specialSeasonDate.text());
				exam.setPeriod(period);
				exam.setURL(anchor.attr("href"));
				exams.add(exam);
			}

		}

		return exams;

	}

	public static List<String> getLocations(final ClipUNLExamImpl exam) {
		final ClipUNLSession session = exam.getSession();
		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		final ClipUNLAcademicYear academicYear = exam.getAcademicYear();
		final ClipUNLPerson person = academicYear.getPerson();
		final ClipUNLPeriod period = exam.getPeriod();

		data.put(ClipUNLParameterType.ACADEMIC_YEAR, academicYear.getYear());
		data.put(ClipUNLParameterType.STUDENT, person.getId());
		data.put(ClipUNLParameterType.PERIOD, period.getPeriod());
		data.put(ClipUNLParameterType.PERIOD_TYPE, period.getPeriodType()
				.getCode());
		data.put(ClipUNLParameterType.DETAILS, exam.getId());

		final Document document = getDocument(session,
				ClipUNLPath.STUDENT_CALENDAR, data, Method.GET);
		
		final Elements lines = document.select(LOCATIONS_LIST_ITEM_SELECTOR);
		
		final List<String> locations = new ArrayList<String>();
		
		for (final Element line : lines) {
			locations.add(line.text());
		}

		return locations;
	}

}
