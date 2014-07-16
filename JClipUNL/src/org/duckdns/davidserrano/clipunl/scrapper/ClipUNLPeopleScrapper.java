package org.duckdns.davidserrano.clipunl.scrapper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.NotLoggedInException;
import org.duckdns.davidserrano.clipunl.exceptions.PageChangedException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.impl.ClipUNLPersonImpl;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLPeopleScrapper extends ClipUNLScrapper {
	private final static String PEOPLE_ANCHOR_SELECTOR = "table:has(span.h3:containsOwn("
			+ ClipUNLConstants.CLIP_STUDENT_LABEL
			+ ")) a[href^="
			+ ClipUNLConstants.CLIP_STUDENT_PATH + "?]";

	public static List<ClipUNLPerson> getPeople(final ClipUNLSession session) {
		if (!session.isLoggedIn()) {
			throw new NotLoggedInException();
		}

		final Document document = getDocument(session,
				ClipUNLConstants.CLIP_LOGIN_PATH);
		final List<ClipUNLPerson> people = new ArrayList<>();

		// Find the student anchors
		final Elements elements = document.select(PEOPLE_ANCHOR_SELECTOR);

		// There must be at least one
		if (elements.size() == 0) {
			throw new PageChangedException(ClipUNLConstants.CLIP_LOGIN_PATH);
		}

		for (final Element element : elements) {
			if (element.select("span").size() > 0) {
				continue;
			}
			final String description = element.text();
			final String url = element.attr("href");
			final String id;

			try {
				final String qs = url.split("\\?")[1];
				final Map<String, String> qsMap = ClipUNLUtil
						.splitQueryString(qs);
				id = qsMap.get(ClipUNLConstants.CLIP_PARAM_STUDENT);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new PageChangedException(ClipUNLConstants.CLIP_LOGIN_PATH);
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
