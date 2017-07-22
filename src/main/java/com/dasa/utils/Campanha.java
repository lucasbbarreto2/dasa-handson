package com.dasa.utils;

public class Campanha {
	private String campanha;
	private Long participantes;
	private Long qtdHomens;
	private Long qtdMulheres;
	private String proporcaoHomens;//passar para string
	private String proporcaoMulheres;
	
	public Campanha(String campanha, Long participantes, Long qtdHomens, Long qtdMulheres){
		this.campanha = campanha;
		this.participantes = participantes;
		this.qtdHomens = qtdHomens;
		this.qtdMulheres = qtdMulheres;
		this.setProporcaoHomens(String.valueOf((qtdHomens.doubleValue()/participantes.doubleValue())*100)+"%");
		this.setProporcaoMulheres(String.valueOf((qtdMulheres.doubleValue()/participantes.doubleValue())*100)+"%");
	}
	
	public String getCampanha() {
		return campanha;
	}

	public Long getParticipantes() {
		return participantes;
	}

	public Long getQtdHomens() {
		return qtdHomens;
	}

	public Long getQtdMulheres() {
		return qtdMulheres;
	}

	public String getProporcaoHomens() {
		return proporcaoHomens;
	}

	public void setProporcaoHomens(String proporcaoHomens) {
		this.proporcaoHomens = proporcaoHomens;
	}

	public String getProporcaoMulheres() {
		return proporcaoMulheres;
	}

	public void setProporcaoMulheres(String proporcaoMulheres) {
		this.proporcaoMulheres = proporcaoMulheres;
	}


}
