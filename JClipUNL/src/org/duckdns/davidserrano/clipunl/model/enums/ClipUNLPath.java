package org.duckdns.davidserrano.clipunl.model.enums;

import org.duckdns.davidserrano.clipunl.util.ClipUNLConstants;
import org.duckdns.davidserrano.clipunl.util.ClipUNLUtil;

public enum ClipUNLPath {
	OBJECT("/objecto"),

	HOME("/utente/eu"),

	STUDENT(HOME.getPath() + "/aluno"),

	STUDENT_ACADEMIC_YEAR(STUDENT.getPath() + "/ano_lectivo"),

	STUDENT_CURRICULAR_UNITS(STUDENT_ACADEMIC_YEAR.getPath() + "/unidades"),

	STUDENT_DOCUMENTS(STUDENT_CURRICULAR_UNITS.getPath()
			+ "/unidade_curricular/actividade/documentos"),

	STUDENT_CALENDAR(STUDENT_ACADEMIC_YEAR.getPath() + "/"
			+ ClipUNLUtil.encode("calendário"));

	private String path;

	ClipUNLPath(final String path) {
		this.path = path;
	}

	public static ClipUNLPath from(final String path) {
		for (final ClipUNLPath typ : ClipUNLPath.values()) {
			if (typ.getPath().equals(path)) {
				return typ;
			}
		}

		return null;
	}

	public String getPath() {
		return path;
	}

	public String getURL() {
		return ClipUNLConstants.CLIP_SERVER + getPath();
	}
}
