package com.dasa.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dasa.service.DadosPopulacionaisService;
import com.dasa.service.DadosPopulacionaisServiceimpl;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {
	private final String ano;
	private final String proporcaoHomem;
	private final String proporcaoMulher;
	private final String totalParticipantes;
	
	@Autowired
	DadosPopulacionaisService service;
	
	public EstatisticaAnoResponse(DadoPopulacional pop) {
		
		this.ano = pop.getAno();
		this.totalParticipantes  = pop.getPopulacaoTotal().toString();
		BigDecimal proporcaoHomem = new BigDecimal(pop.getTotalHomens().toString());
		BigDecimal proporcaoMulher = new BigDecimal(pop.getTotalMulheres().toString());		
		this.proporcaoHomem  = proporcaoHomem.divide(pop.getPopulacaoTotal(),6, BigDecimal.ROUND_HALF_UP)
				.movePointRight(2).toString()+"%";
		this.proporcaoMulher = proporcaoMulher.divide(pop.getPopulacaoTotal(),6, BigDecimal.ROUND_HALF_UP)
				.movePointRight(2).toString()+"%";
			
	}
	
}
