package org.duckdns.davidserrano.clipunl.model.enums;

public enum ClipUNLPeriodType {
	SEMESTER("s", "Semestre"), TRIMESTER("t", "Trimestre");

	private String code;
	private String label;

	ClipUNLPeriodType(final String value, final String label) {
		this.code = value;
		this.label = label;
	}

	public static ClipUNLPeriodType from(final String code) {
		for (final ClipUNLPeriodType typ : ClipUNLPeriodType.values()) {
			if (typ.getCode().equals(code)) {
				return typ;
			}
		}

		return null;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
}
