package org.duckdns.davidserrano.clipunl.scraper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.exceptions.PageChangedException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYearImpl;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLAcademicYearScraper extends ClipUNLScraper {
	private final static String ACADEMIC_YEARS_ANCHOR_SELECTOR = "table:has(span.h3:containsOwn("
			+ ClipUNLConstants.CLIP_ACADEMIC_YEAR_LABEL
			+ ")) a[href^="
			+ ClipUNLPath.STUDENT_ACADEMIC_YEAR.getCode() + "?]";

	public static List<ClipUNLAcademicYear> getAcademicYears(
			ClipUNLSession session, ClipUNLPerson person) {

		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final List<ClipUNLAcademicYear> years = new ArrayList<ClipUNLAcademicYear>();
		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		data.put(ClipUNLParameterType.STUDENT, person.getId());
		final Document document = getDocument(session, ClipUNLPath.STUDENT,
				data, Method.GET);

		final Elements academicYearAnchors = document
				.select(ACADEMIC_YEARS_ANCHOR_SELECTOR);

		if (academicYearAnchors.size() == 0) {
			throw new PageChangedException(ClipUNLPath.STUDENT);
		}

		for (final Element element : academicYearAnchors) {
			if (element.select("span").size() > 0) {
				continue;
			}

			final ClipUNLAcademicYearImpl academicYear = new ClipUNLAcademicYearImpl(
					session);

			final String url = element.attr("href");
			final String year;

			try {
				final Map<ClipUNLParameterType, String> qsMap = ClipUNLUtil
						.splitQueryString(url);
				year = qsMap.get(ClipUNLParameterType.ACADEMIC_YEAR);
			} catch (Exception e) {
				throw new PageChangedException(ClipUNLPath.STUDENT);
			}

			academicYear.setPerson(person);
			academicYear.setDescription(element.text());
			academicYear.setURL(url);
			academicYear.setYear(year);

			years.add(academicYear);
		}

		return years;
	}
}
