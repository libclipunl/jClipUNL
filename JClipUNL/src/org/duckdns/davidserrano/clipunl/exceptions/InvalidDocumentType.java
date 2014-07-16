package org.duckdns.davidserrano.clipunl.exceptions;

public class InvalidDocumentType extends ClipUNLException {
	private static final long serialVersionUID = -4799130193640397216L;
	
	private final String documentType;
	
	public InvalidDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	@Override
	public String getMessage() {
		return "Invalid document type: " + documentType;
	}
}
