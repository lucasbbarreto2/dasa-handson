package com.dasa.domain;

import lombok.Data;

@Data
public class ParticipacaoResponse {
	
	private final String ano;
	private final String campanha;
	private final Character sexo; 
	
	public ParticipacaoResponse(DadoParticipacao part){
		this.ano = part.getAno();
		this.campanha = part.getCampanha();
		this.sexo = part.getSexo();
	}
}
