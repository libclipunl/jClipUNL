package org.duckdns.davidserrano.clipunl.samples.listevents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNL;
import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.scrapper.ClipUNLPeopleScrapper;

public class ClipUNLListEvents {
	public static final void listAcademicYears(ClipUNLPerson person) {
		final List<ClipUNLAcademicYear> academicYears = person
				.getAcademicYears();
		for (final ClipUNLAcademicYear academicYear : academicYears) {
			System.out.println("\t" + academicYear.getDescription());
		}

	}

	public static final void listPeople(ClipUNLSession session) {
		final List<ClipUNLPerson> people = ClipUNLPeopleScrapper
				.getPeople(session);

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

			session = ClipUNL.getSession(identifier, password);

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
