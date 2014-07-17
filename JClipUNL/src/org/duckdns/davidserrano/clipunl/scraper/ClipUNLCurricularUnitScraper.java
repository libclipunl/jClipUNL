package org.duckdns.davidserrano.clipunl.scraper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.exceptions.PageChangedException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnitImpl;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriodImpl;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPeriodType;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLCurricularUnitScraper extends ClipUNLScraper {
	private final static String CURRICULAR_UNITS_ANCHOR_SELECTOR = "table:has(span.h3:containsOwn("
			+ ClipUNLConstants.CURRICULAR_UNITS_LABEL
			+ ")) a[href^="
			+ ClipUNLPath.STUDENT_CURRICULAR_UNITS.getPath() + "?]";

	public static List<ClipUNLCurricularUnit> getCurricularUnits(
			final ClipUNLAcademicYear academicYear) {
		final ClipUNLSession session = academicYear.getSession();

		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final List<ClipUNLCurricularUnit> curricularUnits = new ArrayList<ClipUNLCurricularUnit>();
		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		final ClipUNLPerson person = academicYear.getPerson();

		data.put(ClipUNLParameterType.STUDENT, person.getId());
		data.put(ClipUNLParameterType.ACADEMIC_YEAR, academicYear.getYear());
		final Document document = getDocument(session,
				ClipUNLPath.STUDENT_ACADEMIC_YEAR, data, Method.GET);

		final Elements elements = document
				.select(CURRICULAR_UNITS_ANCHOR_SELECTOR);

		if (elements.size() == 0) {
			throw new PageChangedException(ClipUNLPath.STUDENT_ACADEMIC_YEAR);
		}

		for (final Element element : elements) {
			if (element.select("span").size() > 0) {
				continue;
			}

			final ClipUNLCurricularUnitImpl curricularUnit = new ClipUNLCurricularUnitImpl(
					session);

			final String id;
			final String url = element.attr("href");
			final String name = element.text();
			final ClipUNLPeriod period;

			try {
				final Map<ClipUNLParameterType, String> qsMap = ClipUNLUtil
						.splitQueryString(url);

				id = qsMap.get(ClipUNLParameterType.UNIT);
				final String periodStr = qsMap.get(ClipUNLParameterType.PERIOD);
				final ClipUNLPeriodType periodType = ClipUNLPeriodType
						.from(qsMap.get(ClipUNLParameterType.PERIOD_TYPE));

				period = new ClipUNLPeriodImpl(session, periodStr, periodType);

			} catch (UnsupportedEncodingException e) {
				throw new PageChangedException(
						ClipUNLPath.STUDENT_ACADEMIC_YEAR);
			}

			curricularUnit.setId(id);
			curricularUnit.setAcademicYear(academicYear);
			curricularUnit.setUrl(url);
			curricularUnit.setName(name);
			curricularUnit.setPeriod(period);

			curricularUnits.add(curricularUnit);
		}

		return curricularUnits;
	}
}
