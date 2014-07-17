package org.duckdns.davidserrano.clipunl.model.enums;

public enum ClipUNLPeriodType {
	SEMESTER("s", "Semestre", 2), TRIMESTER("t", "Trimestre", 3);

	private String code;
	private String label;
	private int maxPeriod;

	ClipUNLPeriodType(final String value, final String label,
			final int maxPeriod) {
		this.code = value;
		this.label = label;
		this.maxPeriod = maxPeriod;
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

	public int getMaxPeriod() {
		return maxPeriod;
	}
}
