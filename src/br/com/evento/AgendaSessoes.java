package br.com.evento;

import br.com.evento.helper.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import br.com.evento.domain.Sessao;

public class AgendaSessoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero = 1; 
		Sessao sessao = new Sessao(	LocalDateTime.of(
													LocalDate.of(2022, 7, 20), 
													LocalTime.of(10, 0)));
		Sessao limite = new Sessao(	LocalDateTime.of(
				LocalDate.of(2022, 11, 1), 
				LocalTime.of(0, 0)));
		
		Map<Integer,Sessao> sessoes = new HashMap<Integer, Sessao>();
		
		while (sessao.getDataHoraEvento().isBefore(limite.getDataHoraEvento())) {
			
			sessoes.put(numero++, sessao);
			sessao = new Sessao(sessao.getDataHoraEvento().plusDays(10).plusHours(2));
		}
		
		//Local
		System.out.println("Local: São Paulo");
		
		for (Integer indice: sessoes.keySet()) {
			
			sessao = sessoes.get(indice);
			//Número da sessão: indice - Data - Dia da Semana
			System.out.printf("Sessao nº: %2d - Data: %s - %s%n", 
					indice, sessao.getDataEvento(), sessao.getDiaDaSemana());
			//Hora Inicio - Hora Encerramento
			System.out.printf("Início: %s - Encerramento: %s%n%n", 
					sessao.getHoraEvento(), sessao.getHoraEncerramento());	
		}
		
		//Local
		System.out.println("Local: Paris");//System.out.println(Util.capitalizePrimeiraletra(Util.getDiaDaSemana("07/03/2017"))); // TER
		
		for (Integer indice: sessoes.keySet()) {
			
			sessao = sessoes.get(indice);
			//Número da sessão: indice - Data - Dia da Semana
			System.out.printf("Sessao nº: %2d - Data: %s - %s%n", 
					indice, sessao.getDataEventoFranca(), sessao.getDiaDaSemanaFranca());
			//Hora Inicio - Hora Encerramento
			System.out.printf("Início: %s - Encerramento: %s%n%n", 
					sessao.getHoraEventoFranca(), sessao.getHoraEncerramentoFranca());	
		}
	}
}
