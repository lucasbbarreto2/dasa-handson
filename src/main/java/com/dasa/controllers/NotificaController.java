package com.dasa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoParticipacao;
import com.dasa.domain.DadosCampanhasAnoResponse;
import com.dasa.domain.ParticipacaoResponse;
import com.dasa.service.DadoParticipacaoService;
import com.dasa.utils.Campanha;

@RestController
public class NotificaController {
	
	@Autowired
	DadoParticipacaoService service;
	
	@RequestMapping("/notifica/{ano}/{sexo}/{campanha}")
	public ParticipacaoResponse inseriNotificacao(@PathVariable("ano") String ano, @PathVariable("sexo") String sexo, 
			@PathVariable("campanha") String campanha){
		DadoParticipacao dp = service.inserirDadoParticipacao(Optional.of((new DadoParticipacao(ano, campanha, sexo))));
		ParticipacaoResponse pr = new ParticipacaoResponse(dp);
		return pr;
	}
	
	@RequestMapping("/campanhas/{ano}")
	public DadosCampanhasAnoResponse buscaCampanhasAno(@PathVariable("ano") String ano){
		List<Campanha> listaCampanhas = service.obterDadoPorCampanhaAno(Optional.of(ano));
		DadosCampanhasAnoResponse dc = new DadosCampanhasAnoResponse(ano, listaCampanhas);
		return dc;
	}
	
	//@RequestMapping("/proporcao-participacao/{ano}")
	
}
