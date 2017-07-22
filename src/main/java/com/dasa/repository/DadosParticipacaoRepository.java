package com.dasa.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.DadoParticipacao;

import org.springframework.data.domain.Sort;

@Transactional
public interface DadosParticipacaoRepository extends CrudRepository<DadoParticipacao, Long> {
	
	ArrayList<DadoParticipacao> findByAno(final String ano, Sort sort);
	DadoParticipacao findById(final String id);
	ArrayList<DadoParticipacao> findByCampanha(final String campanha);
	
	
}
