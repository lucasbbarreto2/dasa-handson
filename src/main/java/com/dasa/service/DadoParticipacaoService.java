package com.dasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dasa.domain.DadoParticipacao;
import com.dasa.utils.Campanha;

public interface DadoParticipacaoService {
	
	DadoParticipacao obterDadoParticipantePorId(final Optional<String>  id);
	DadoParticipacao inserirDadoParticipacao(final Optional<DadoParticipacao>  dp);
	List<Campanha> obterDadoPorCampanhaAno(final Optional<String> ano);
}
