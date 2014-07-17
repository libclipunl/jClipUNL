package org.duckdns.davidserrano.clipunl.samples.listfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.ClipUNLSessionFactory;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLDocument;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.model.enums.ClipUNLDocumentType;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLPeopleScraper;

public class ClipUNLListFiles {

	private static void listDocuments(ClipUNLCurricularUnit curricularUnit) {
		final Map<ClipUNLDocumentType, List<ClipUNLDocument>> documentsByType = curricularUnit
				.getDocumentsByType();

		for (final Entry<ClipUNLDocumentType, List<ClipUNLDocument>> entry : documentsByType
				.entrySet()) {
			final ClipUNLDocumentType documentType = entry.getKey();
			final List<ClipUNLDocument> documents = entry.getValue();

			if (documents.size() > 0) {
				System.out.println("\t\t\t" + documentType.getLabel() + "("
						+ documents.size() + ")");

				for (final ClipUNLDocument document : documents) {
					System.out.println("\t\t\t\t" + document.getName() + "\t"
							+ document.getTeacher() + " " + document.getURL());
				}
			}
		}
	}

	private static void listCurricularUnits(ClipUNLAcademicYear academicYear) {
		final List<ClipUNLCurricularUnit> curricularUnits = academicYear
				.getCurricularUnits();

		for (final ClipUNLCurricularUnit curricularUnit : curricularUnits) {
			System.out.println("\t\t" + curricularUnit.getName());
			listDocuments(curricularUnit);
		}

	}

	private static final void listAcademicYears(ClipUNLPerson person) {
		final List<ClipUNLAcademicYear> academicYears = person
				.getAcademicYears();
		for (final ClipUNLAcademicYear academicYear : academicYears) {
			System.out.println("\t" + academicYear.getDescription());
			listCurricularUnits(academicYear);
		}

	}

	private static final void listPeople(ClipUNLSession session) {
		final List<ClipUNLPerson> people = session.getPeople();

		for (final ClipUNLPerson person : people) {
			System.out.println(person.getDescription());
			listAcademicYears(person);
		}
	}

	public static final void main(final String args[]) {

		final String identifier;
		final String password;
		final ClipUNLSession session;

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println("CLIP identifier: ");
			identifier = reader.readLine();

			System.out.println("Password: ");
			password = reader.readLine();

			session = ClipUNLSessionFactory.getSession(identifier, password);

			if (session.isLoggedIn()) {
				System.out.println("Welcome " + session.getFullName());
			} else {
				System.out.println("Wrong identifier/password combination");
				return;
			}

			listPeople(session);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
