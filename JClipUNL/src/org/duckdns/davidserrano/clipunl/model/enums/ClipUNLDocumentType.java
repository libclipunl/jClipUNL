package org.duckdns.davidserrano.clipunl.model.enums;

public enum ClipUNLDocumentType {
	TRANSPARENCIES("0ac", "Acetatos"),

	PROBLEMS("1e", "Problemas"),

	PROTOCOLS("2tr", "Protocolos"),

	SEMINARIES("3sm", "Seminários"),

	EXAMS("ex", "Exames"),

	TESTS("t", "Testes"),

	SUPPORT_TEXTS("ta", "Textos de Apoio"),

	OTHERS("xot", "Outros");

	private String code;
	private String description;

	ClipUNLDocumentType(final String code, final String description) {
		this.code = code;
		this.description = description;
	}

	public ClipUNLDocumentType from(final String code) {
		for (final ClipUNLDocumentType typ : ClipUNLDocumentType.values()) {
			if (typ.getCode().equals(code)) {
				return typ;
			}
		}

		return null;
	}

	public String getCode() {
		return code;
	}

	public String getDescrition() {
		return description;
	}
}
