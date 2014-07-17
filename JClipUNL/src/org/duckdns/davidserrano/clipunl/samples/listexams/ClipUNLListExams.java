package org.duckdns.davidserrano.clipunl.samples.listexams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.ClipUNLSessionFactory;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExam;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;

public class ClipUNLListExams {

	private static void listExams(ClipUNLAcademicYear academicYear) {
		final List<ClipUNLExam> exams = academicYear.getExams();

		for (final ClipUNLExam exam : exams) {
			final Interval interval = exam.getInterval();
			System.out.println("\t\t"
					+ DateTimeFormat.forPattern(
							ClipUNLConstants.CLIP_DATETIME_FORMAT).print(
							interval.getStart()) + " "
					+ exam.getCurricularUnitName());

			for (final String location : exam.getLocations()) {
				System.out.println("\t\t\t* " + location);
			}
		}
	}

	private static final void listAcademicYears(ClipUNLPerson person) {
		final List<ClipUNLAcademicYear> academicYears = person
				.getAcademicYears();
		for (final ClipUNLAcademicYear academicYear : academicYears) {
			System.out.println("\t Exams for " + academicYear.getDescription());
			listExams(academicYear);
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
			System.out.println("CLIP Exam Lister");
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
