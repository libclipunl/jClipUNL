package org.duckdns.davidserrano.clipunl.scraper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocumentImpl;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLDocumentScraper extends ClipUNLScraper {
	private final static String DOCUMENT_LINES_SELECTOR = "table tr:has(td a[href^="
			+ ClipUNLPath.OBJECT.getCode()
			+ "] img[src="
			+ ClipUNLConstants.CLIP_DL_IMAGE + "])";

	public static List<ClipUNLDocument> getDocuments(
			final ClipUNLCurricularUnit curricularUnit,
			final ClipUNLDocumentType documentType) {

		final ClipUNLSession session = curricularUnit.getSession();

		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final Map<ClipUNLParameterType, String> data = new LinkedHashMap<ClipUNLParameterType, String>();

		final ClipUNLAcademicYear academicYear = curricularUnit
				.getAcademicYear();
		final ClipUNLPerson person = academicYear.getPerson();
		final ClipUNLPeriod period = curricularUnit.getPeriod();

		data.put(ClipUNLParameterType.ACADEMIC_YEAR, academicYear.getYear());
		data.put(ClipUNLParameterType.STUDENT, person.getId());
		data.put(ClipUNLParameterType.CURRICULAR_UNIT, curricularUnit.getId());
		data.put(ClipUNLParameterType.PERIOD, period.getPeriod());
		data.put(ClipUNLParameterType.PERIOD_TYPE, period.getPeriodType()
				.getCode());
		data.put(ClipUNLParameterType.UNIT_DOCTYPE, documentType.getCode());

		final Document document = getDocument(session,
				ClipUNLPath.STUDENT_DOCUMENTS, data, Method.GET);

		final Elements lines = document.select(DOCUMENT_LINES_SELECTOR);

		final List<ClipUNLDocument> clipDocuments = new ArrayList<ClipUNLDocument>();

		if (lines.size() > 1) {

			for (final Element line : lines.subList(1, lines.size())) {
				final ClipUNLDocumentImpl clipDocument = new ClipUNLDocumentImpl(
						session);

				final String name = line.child(0).text();
				final String url = line.child(1).select("a").attr("href");
				final String date = line.child(2).text();
				final String size = line.child(3).text();
				final String teacher = line.child(4).text();

				clipDocument.setDocumentType(documentType);
				clipDocument.setName(name);
				clipDocument.setURL(url);
				clipDocument.setDate(date);
				clipDocument.setSize(size);
				clipDocument.setTeacher(teacher);

				clipDocuments.add(clipDocument);
			}
		}

		return clipDocuments;
	}
}
