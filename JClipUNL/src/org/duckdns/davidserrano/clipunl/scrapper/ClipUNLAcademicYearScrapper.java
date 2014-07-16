package org.duckdns.davidserrano.clipunl.scrapper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.exceptions.PageChangedException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.impl.ClipUNLAcademicYearImpl;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLAcademicYearScrapper extends ClipUNLScrapper {
	private final static String ACADEMIC_YEARS_ANCHOR_SELECTOR = "table:has(span.h3:containsOwn("
			+ ClipUNLConstants.CLIP_ACADEMIC_YEAR_LABEL
			+ ")) a[href^="
			+ ClipUNLConstants.CLIP_STUDENT_ACADEMIC_YEAR_PATH + "?]";

	public static List<ClipUNLAcademicYear> getAcademicYears(
			ClipUNLSession session, String personId) {
		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final List<ClipUNLAcademicYear> years = new ArrayList<ClipUNLAcademicYear>();
		final Map<String, String> data = new HashMap<String, String>();

		data.put(ClipUNLConstants.CLIP_PARAM_STUDENT, personId);
		final Document document = getDocument(session,
				ClipUNLConstants.CLIP_STUDENT_PATH, data, Method.GET);

		final Elements academicYearAnchors = document
				.select(ACADEMIC_YEARS_ANCHOR_SELECTOR);

		if (academicYearAnchors.size() == 0) {
			throw new PageChangedException(ClipUNLConstants.CLIP_STUDENT_PATH);
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
				final String qs = url.split("\\?")[1];
				final Map<String, String> qsMap = ClipUNLUtil
						.splitQueryString(qs);
				year = qsMap.get(ClipUNLConstants.CLIP_PARAM_ACADEMIC_YEAR);
			} catch (IndexOutOfBoundsException e) {
				throw new PageChangedException(
						ClipUNLConstants.CLIP_STUDENT_PATH);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new PageChangedException(
						ClipUNLConstants.CLIP_STUDENT_PATH);
			}

			academicYear.setDescription(element.text());
			academicYear.setURL(url);
			academicYear.setYear(year);

			years.add(academicYear);
		}

		return years;
	}

	public static List<ClipUNLAcademicYear> getAcademicYears(
			ClipUNLSession session, ClipUNLPerson person) {

		return getAcademicYears(session, person.getId());
	}
}
