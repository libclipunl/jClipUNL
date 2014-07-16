package org.duckdns.davidserrano.clipunl.model.enums;

public enum ClipUNLParameterType {
	UNIT("unidade"),
	
	CURRICULAR_UNIT("unidade_curricular"),
	
	YEAR("ano_lectivo"),
	
	PERIOD("período_lectivo"),
	
	PERIOD_TYPE("tipo_de_período_lectivo"),
	
	STUDENT("aluno"),
	
	UNIT_DOCTYPE("tipo_de_document_unidade");
	
	private String code;
	
	ClipUNLParameterType(final String value) {
		this.code = value;
	}
	
	public ClipUNLParameterType from(final String code) {
		for (final ClipUNLParameterType typ : ClipUNLParameterType.values()) {
			if (typ.getCode().equals(code)) {
				return typ;
			}
		}
		
		return null;
	}
	
	public String getCode() {
		return code;
	}
}
