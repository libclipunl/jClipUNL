package org.duckdns.davidserrano.clipunl.model.enums;

import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;

public enum ClipUNLPath {
	OBJECT("/objecto"),

	HOME("/utente/eu"),

	STUDENT(HOME.getCode() + "/aluno"),

	STUDENT_ACADEMIC_YEAR(STUDENT.getCode() + "/ano_lectivo"),
	
	STUDENT_CURRICULAR_UNITS(STUDENT_ACADEMIC_YEAR.getCode() + "/unidades"),

	STUDENT_DOCUMENTS(STUDENT_CURRICULAR_UNITS.getCode()
			+ "/unidade_curricular/actividade/documentos"),

	STUDENT_EXAMS(STUDENT_ACADEMIC_YEAR.getCode() + "/calendário");

	private String code;

	ClipUNLPath(final String value) {
		this.code = value;
	}

	public static ClipUNLPath from(final String code) {
		for (final ClipUNLPath typ : ClipUNLPath.values()) {
			if (typ.getCode().equals(code)) {
				return typ;
			}
		}

		return null;
	}

	public String getCode() {
		return code;
	}

	public String getURL() {
		return ClipUNLConstants.CLIP_SERVER + getCode();
	}
}
