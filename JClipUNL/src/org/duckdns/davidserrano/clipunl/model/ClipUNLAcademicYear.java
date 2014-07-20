package org.duckdns.davidserrano.clipunl.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ClipUNLAcademicYear extends ClipUNLBaseModel, Serializable {
	abstract public String getYear();
	
	abstract public String getURL();
	
	abstract public String getDescription();

	abstract public List<ClipUNLCurricularUnit> getCurricularUnits();
	
	abstract public ClipUNLPerson getPerson();

	public abstract List<ClipUNLExam> getExams();

	public abstract List<ClipUNLExam> getExams(ClipUNLPeriod period);

	public abstract Map<ClipUNLPeriod, List<ClipUNLExam>> getExamsByPeriod();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public int hashCode();
}
