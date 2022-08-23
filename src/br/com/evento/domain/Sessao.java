package br.com.evento.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import br.com.evento.helper.Util;

public class Sessao {
	
		private LocalDateTime dataHoraEvento;
		private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
		
		public Sessao(LocalDateTime dataHoraEvento){
			
			this.setDataHoraEvento(dataHoraEvento);
		}
		
		public LocalDateTime getDataHoraEvento() {
			
			return dataHoraEvento;
		}
		
		public void setDataHoraEvento(LocalDateTime dataHoraEvento) {
			
			this.dataHoraEvento = dataHoraEvento;
		}
		
		public LocalDateTime getDataHoraEncerramento() {
			
			return dataHoraEvento.plusHours(6);
		}
		
		public ZonedDateTime getDataHoraEventoFranca() {
			
	
			DateTimeFormatter formato = DateTimeFormatter.ofPattern(DATE_FORMAT);
			ZoneId zonaEP = ZoneId.of("Europe/Paris");
			ZoneId zonaSP = ZoneId.of("America/Sao_Paulo");
			ZonedDateTime dataHorasSaoPaulo = dataHoraEvento.atZone(zonaSP);
			
			return dataHorasSaoPaulo.withZoneSameInstant(zonaEP);
		}
		
		public ZonedDateTime getDataHoraEncerramentoFranca() {
			
			return getDataHoraEventoFranca().plusHours(6);
		}
		
		public String getDiaDaSemana() {
						
			return Util
					.capitalizePrimeiraletra(Util.
							getDiaDaSemana(dataHoraEvento.toString().substring(0,10)));
		}
		
		public String getDiaDaSemanaFranca() {
			
			
			return Util
					.capitalizePrimeiraletra(getDataHoraEventoFranca()
									.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)).split(",")[0]);
		}
		
		public String getDataEvento() {
				        
			return Util.formataData(getDataHoraEvento().toString());
		}
		
		public String getHoraEvento() {
			
			return Util.formataHora(getDataHoraEvento().toString());
		}
		
		public String getHoraEncerramento() {
			
			return Util.formataHora(getDataHoraEncerramento().toString());
		}

		public String getDataEventoFranca() {
			
			return Util.formataData(getDataHoraEventoFranca().toString());
		}

		public String getHoraEventoFranca() {
			
			return Util.formataHora(getDataHoraEventoFranca().toString());
		}
		
		public String getHoraEncerramentoFranca() {
			
			return Util.formataHora(getDataHoraEncerramentoFranca().toString());
		}
}
