package com.dasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.dasa.domain.DadoParticipacao;
import com.dasa.repository.DadosParticipacaoRepository;
import com.dasa.utils.Campanha;

@Service
public class DadoParticipacaoImpl implements DadoParticipacaoService{
	
	@Autowired
	DadosParticipacaoRepository dadosParticipacaoRepository;
	
	@Override
	public DadoParticipacao obterDadoParticipantePorId(Optional<String> id) {
		String recordId = id.get();
		if(!id.isPresent())
			throw new IllegalArgumentException("Valor de id obrigatório");
		DadoParticipacao dp = dadosParticipacaoRepository.findById(recordId);
		return dp;
	}
	@Override
	public DadoParticipacao inserirDadoParticipacao(Optional<DadoParticipacao> dp) {
		if(!dp.isPresent())
			throw new IllegalArgumentException("Valor de DadoParticipacao obrigatório");
		return dadosParticipacaoRepository.save(dp.get());
	}
	
	@Override
	public List<Campanha> obterDadoPorCampanhaAno(Optional<String> ano) {
		if(!ano.isPresent())
			throw new IllegalArgumentException("Necessário ano para buscar campanhas");
		List<DadoParticipacao> lista = dadosParticipacaoRepository.findByAno(ano.get(),(new Sort("campanha")));
		List<Campanha> listaCampanhas = new ArrayList<>();
		String campanha = lista.isEmpty() ? "" : lista.get(0).getCampanha();
		long qtdHomens = 0;
		long qtdMulheres = 0;
		for(DadoParticipacao listaDp : lista){
			if(listaDp.getCampanha().equals(campanha)){
				if(listaDp.getSexo() == 'M'){
					qtdHomens++;
				}else if(listaDp.getSexo() == 'F'){
					qtdMulheres++;
				}
			}else{
				listaCampanhas.add(new Campanha(campanha, (qtdHomens+qtdMulheres), qtdHomens, qtdMulheres));
				qtdHomens = 0;
				qtdMulheres = 0;
				if(listaDp.getSexo() == 'M'){
					qtdHomens++;
				}else if(listaDp.getSexo() == 'F'){
					qtdMulheres++;
				}
			}
			campanha = listaDp.getCampanha();
		}
		if(!lista.isEmpty())
			listaCampanhas.add(new Campanha(campanha, (qtdHomens+qtdMulheres), qtdHomens, qtdMulheres));
		return listaCampanhas;
	}
}
