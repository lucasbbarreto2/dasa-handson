package com.dasa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.service.DadosPopulacionaisService;

@RestController
public class SampleController {

	@Autowired
	DadosPopulacionaisService service;
	
	@RequestMapping("/hello")
	public String helloWorld(){
		return "Hello =)";
	}
	
	@RequestMapping("/ano/{ano}")
	public EstatisticaAnoResponse getData(@PathVariable String ano){
		
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of(ano));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);

		return stat;
	}
	
}
