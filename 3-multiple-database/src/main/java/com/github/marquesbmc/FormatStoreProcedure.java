package com.github.marquesbmc;

import java.util.Locale;

public class FormatStoreProcedure {	
	
	public static final String FORMATO_CONTA_CORRENTE  = "####.###.########-#";
	public static final String FORMATO_CNPJ  = "##.###.###/####-##";
	public static final String FORMATO_NUMERO  = "#,##0.00; -#,##0.00";  
	public static final String FORMATO_MOEDA = "R$ #,##0.00;R$ -#,##0.00";  
	public static final String FORMATO_PORCENTAGEM = "#,##0.00'%';-#,##0.00'%'";
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static Locale LOCALE_PT_BR = new Locale("pt", "BR");
	
	public static boolean isNotEmpty(String s) {
		return s != null && !s.trim().isEmpty();
	}
	
	public static String toCaixaAlta(String field){
		String retorno = "";
		if(!FormatStoreProcedure.isNotEmpty(field)){
			retorno = field.trim().toUpperCase(LOCALE_PT_BR);
		}
		return retorno;
	}
	

	
	
	
	
	
	
	
}
