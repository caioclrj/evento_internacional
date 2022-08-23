package br.com.evento.helper;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class Util {

	public static String getDiaDaSemana(String data) {
	    
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	    DayOfWeek diadaSemana = DayOfWeek.from(formato.parse(data));
	    return diadaSemana.getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
	}
	
	public static String capitalizePrimeiraletra(String palavra) {
		
		List<String> palavras = Arrays.asList(palavra.split("-"));
		
		return palavras
			.stream()
			.map(item -> item.substring(0,1).toUpperCase().concat(item.substring(1)))
			.reduce((inicio, demais) -> inicio.concat("-").concat(demais))
			.get();
	}
	
	public static String formataData(String data) {
		
		String dia = data.substring(8,10);
		String mes = data.substring(5,7);
		String ano = data.substring(0,4);
		
		return dia + "/" + mes + "/" + ano;		
	}
	public static String formataHora(String data) {
		
		String hora = data.substring(11,13);
		String minuto = data.substring(14,16);
		//String segundo = data.substring(17,19);
		
		return hora + ":" + minuto; //+ ":" + segundo;		
	}
}
