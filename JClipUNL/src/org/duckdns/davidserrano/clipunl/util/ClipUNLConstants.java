package org.duckdns.davidserrano.clipunl.util;

public class ClipUNLConstants {
	public static final String CLIP_ENCODING = "ISO-8859-1";
	public static final String CLIP_SERVER = "https://clip.unl.pt";

	public static final String CLIP_OBJECT = "/objecto";
	public static final String CLIP_LOGIN = "/utente/eu";
	public static final String CLIP_STUDENT = CLIP_LOGIN + "/aluno";
	public static final String CLIP_STUDENT_ACADEMIC_YEAR = CLIP_STUDENT
			+ "/ano_lectivo";
	public static final String CLIP_STUDENT_SUBJECTS = CLIP_STUDENT_ACADEMIC_YEAR
			+ "/unidades";
	public static final String CLIP_STUDENT_DOCUMENTS = CLIP_STUDENT_SUBJECTS
			+ "/unidade_curricular/actividade/documentos";

	public static final String CLIP_STUDENT_EXAMS = CLIP_STUDENT_ACADEMIC_YEAR
			+ "/calendário";

	public static final String CLIP_QS_PARAM_IDENTIFIER = "identificador";
	public static final String CLIP_QS_PARAM_PASSWORD = "senha";

	public static final String CLIP_QS_PARAM_YEAR = "ano_lectivo";
	public static final String CLIP_QS_PARAM_INSTITUTE = "instituição";
	public static final String CLIP_QS_PARAM_STUDENT = "aluno";
	public static final String CLIP_QS_PARAM_PERIOD = "período_lectivo";
	public static final String CLIP_QS_PARAM_PERIOD_TYPE = "tipo_de_período_lectivo";

	public static final Object CLIP_STUDENT_LABEL = "Aluno";

	public static final String CLIP_DL_IMAGE = "/imagem/geral/download.gif";

}
