package org.duckdns.davidserrano.clipunl.scraper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.exceptions.PageChangedException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPersonImpl;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLParameterType;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLPath;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLPeopleScraper extends ClipUNLScraper {
	private final static String PEOPLE_ANCHOR_SELECTOR = "table:has(span.h3:containsOwn("
			+ ClipUNLConstants.CLIP_STUDENT_LABEL
			+ ")) a[href^="
			+ ClipUNLPath.STUDENT.getPath() + "?]";

	public static List<ClipUNLPerson> getPeople(final ClipUNLSession session) {
		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final Document document = getDocument(session, ClipUNLPath.HOME);
		final List<ClipUNLPerson> people = new ArrayList<ClipUNLPerson>();

		// Find the student anchors
		final Elements elements = document.select(PEOPLE_ANCHOR_SELECTOR);

		// There must be at least one
		if (elements.size() == 0) {
			throw new PageChangedException(ClipUNLPath.HOME);
		}

		for (final Element element : elements) {
			if (element.select("span").size() > 0) {
				continue;
			}
			final String description = element.text();
			final String url = element.attr("href");
			final String id;

			try {
				final Map<ClipUNLParameterType, String> qsMap = ClipUNLUtil
						.splitQueryString(url);
				id = qsMap.get(ClipUNLParameterType.STUDENT);
			} catch (Exception e) {
				throw new PageChangedException(ClipUNLPath.HOME);
			}

			final ClipUNLPersonImpl person = new ClipUNLPersonImpl(session);

			person.setId(id);
			person.setDescription(description);
			person.setURL(url);

			people.add(person);
		}

		return people;
	}
}
