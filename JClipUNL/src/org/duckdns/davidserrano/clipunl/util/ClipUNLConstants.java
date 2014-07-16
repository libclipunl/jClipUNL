package org.duckdns.davidserrano.clipunl.util;

public class ClipUNLConstants {
	public static final String CLIP_ENCODING = "ISO-8859-1";
	public static final String CLIP_SERVER = "https://clip.unl.pt";

	public static final String CLIP_OBJECT_PATH = "/objecto";
	public static final String CLIP_LOGIN_PATH = "/utente/eu";
	public static final String CLIP_STUDENT_PATH = CLIP_LOGIN_PATH + "/aluno";
	public static final String CLIP_STUDENT_ACADEMIC_YEAR_PATH = CLIP_STUDENT_PATH
			+ "/ano_lectivo";
	public static final String CLIP_STUDENT_SUBJECTS_PATH = CLIP_STUDENT_ACADEMIC_YEAR_PATH
			+ "/unidades";
	public static final String CLIP_STUDENT_DOCUMENTS_PATH = CLIP_STUDENT_SUBJECTS_PATH
			+ "/unidade_curricular/actividade/documentos";

	public static final String CLIP_STUDENT_EXAMS_PATH = CLIP_STUDENT_ACADEMIC_YEAR_PATH
			+ "/calendário";

	public static final String CLIP_PARAM_IDENTIFIER = "identificador";
	public static final String CLIP_PARAM_PASSWORD = "senha";

	public static final String CLIP_PARAM_ACADEMIC_YEAR = "ano_lectivo";
	public static final String CLIP_PARAM_INSTITUTE = "instituição";
	public static final String CLIP_PARAM_STUDENT = "aluno";
	public static final String CLIP_PARAM_PERIOD = "período_lectivo";
	public static final String CLIP_PARAM_PERIOD_TYPE = "tipo_de_período_lectivo";

	public static final Object CLIP_STUDENT_LABEL = "Aluno";
	public static final String CLIP_ACADEMIC_YEAR_LABEL = "Ano lectivo";

	public static final String CLIP_DL_IMAGE = "/imagem/geral/download.gif";
	

}
