package org.duckdns.davidserrano.clipunl.model.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.duckdns.davidserrano.clipunl.ClipUNLSession;
import org.duckdns.davidserrano.clipunl.model.ClipUNLAcademicYear;
import org.duckdns.davidserrano.clipunl.model.ClipUNLCurricularUnit;
import org.duckdns.davidserrano.clipunl.model.ClipUNLExam;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPeriod;
import org.duckdns.davidserrano.clipunl.model.ClipUNLPerson;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLCurricularUnitScraper;
import org.duckdns.davidserrano.clipunl.scraper.ClipUNLExamScraper;
import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;

public class ClipUNLAcademicYearImpl extends ClipUNLBaseModelImpl implements
		ClipUNLAcademicYear {

	private static final long serialVersionUID = 8880192762897160163L;

	private String year;
	private String url;
	private String description;
	private ClipUNLPerson person;

	private List<ClipUNLCurricularUnit> curricularUnits;

	private Map<ClipUNLPeriod, List<ClipUNLExam>> examsByPeriod;
	private boolean allPeriodsChecked;

	public ClipUNLAcademicYearImpl(ClipUNLSession session) {
		super(session);
		curricularUnits = null;
		examsByPeriod = null;
		allPeriodsChecked = false;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getURL() {
		return ClipUNLConstants.CLIP_SERVER + url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ClipUNLPerson getPerson() {
		return person;
	}

	public void setPerson(ClipUNLPerson person) {
		this.person = person;
	}

	@Override
	public List<ClipUNLCurricularUnit> getCurricularUnits() {
		if (curricularUnits == null) {
			curricularUnits = ClipUNLCurricularUnitScraper
					.getCurricularUnits(this);
		}

		return curricularUnits;
	}

	@Override
	public List<ClipUNLExam> getExams() {
		examsByPeriod = getExamsByPeriod();

		final List<ClipUNLExam> exams = new ArrayList<ClipUNLExam>();

		for (final Entry<ClipUNLPeriod, List<ClipUNLExam>> entry : examsByPeriod
				.entrySet()) {

			exams.addAll(entry.getValue());
		}

		return exams;
	}

	@Override
	public List<ClipUNLExam> getExams(ClipUNLPeriod period) {
		if (examsByPeriod == null) {
			examsByPeriod = new LinkedHashMap<ClipUNLPeriod, List<ClipUNLExam>>();
		}

		if (!examsByPeriod.containsKey(period)) {
			examsByPeriod
					.put(period, ClipUNLExamScraper.getExams(this, period));
		}

		return examsByPeriod.get(period);
	}

	@Override
	public Map<ClipUNLPeriod, List<ClipUNLExam>> getExamsByPeriod() {
		if (examsByPeriod == null) {
			examsByPeriod = new LinkedHashMap<ClipUNLPeriod, List<ClipUNLExam>>();
		}

		if (!allPeriodsChecked) {
			for (final ClipUNLPeriod period : ClipUNLExamScraper
					.getPeriods(this)) {

				examsByPeriod.put(period, getExams(period));
			}
		}
		allPeriodsChecked = true;

		return examsByPeriod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClipUNLAcademicYearImpl other = (ClipUNLAcademicYearImpl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}
