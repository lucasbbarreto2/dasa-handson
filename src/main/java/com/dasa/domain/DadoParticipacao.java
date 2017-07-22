package com.dasa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dados_participacao")
public class DadoParticipacao implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ano;
	private String campanha;
	private Character sexo;
	
	public DadoParticipacao(){}
	
	public DadoParticipacao(final String ano, final String campanha, String sexo){
		this.ano = ano;
		this.campanha = campanha;
		sexo = sexo.toUpperCase();
		this.sexo = sexo.charAt(0);
	}

	public String getAno() {
		return ano;
	}


	public String getCampanha() {
		return campanha;
	}


	public Character getSexo() {
		return sexo;
	}
	
	public Long getId(){
		return this.id;
	}


}
