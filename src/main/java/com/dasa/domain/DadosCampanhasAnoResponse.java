package com.dasa.domain;

import java.util.Arrays;
import java.util.List;

import com.dasa.utils.Campanha;

import lombok.Data;

@Data
public class DadosCampanhasAnoResponse {
	private String ano;
	private Campanha[] campanhas;
	
	public DadosCampanhasAnoResponse(){}
	
	public DadosCampanhasAnoResponse(final String ano, final List<Campanha> campanhas){
		this.ano = ano;
		this.campanhas = campanhas.toArray(new Campanha[0]);
		
	}
}
