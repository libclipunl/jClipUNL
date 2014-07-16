package org.duckdns.davidserrano.clipunl.scrapper;

import java.util.ArrayList;
import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.exceptions.PageChangedException;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.impl.ClipUNLPersonImpl;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClipUNLPeopleScrapper extends ClipUNLScrapper {

	// TODO: me
	public static List<ClipUNLPerson> getPeople(final Document document) {
		final List<ClipUNLPerson> people = new ArrayList<>();
		final Elements elements = document.select("table[cellpadding=3]");

		Element studentTable = null;

		for (Element element : elements) {
			if (element.select("a").get(0).text()
					.equals(ClipUNLConstants.CLIP_STUDENT_LABEL)) {
				studentTable = element;
				break;
			}
		}

		if (studentTable == null) {
			throw new PageChangedException();
		}

		final Elements anchors = studentTable.select(":not(:first-child) a[href^="
				+ ClipUNLConstants.CLIP_STUDENT + "]");

		if (anchors.size() == 0) {
			throw new PageChangedException();
		}

		for (final Element anchor : anchors) {
			final String id = anchor.text();
			final String url = anchor.attr("href");
			final ClipUNLPersonImpl person = new ClipUNLPersonImpl();

			person.setId(id);
			person.setUrl(url);

			people.add(person);
		}

		return people;
	}

	public static List<ClipUNLPerson> getPeople(final ClipUNLSession session) {
		final Document document = getDocument(session,
				ClipUNLConstants.CLIP_LOGIN);

		return getPeople(document);
	}
}
