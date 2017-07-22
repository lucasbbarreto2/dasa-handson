package com.dasa.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dados_populacionais")
public class DadoPopulacional implements Serializable, Comparable<DadoPopulacional> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ano;

    private BigDecimal populacaoTotal;

    private Long totalHomens;

    private Long totalMulheres;

    public DadoPopulacional() {
    }

    public DadoPopulacional(final String ano, final String totalPopulacao, final String totalHomens, final String totalMulheres) {
        this.ano = ano;
        this.populacaoTotal = BigDecimal.valueOf(Long.valueOf(totalPopulacao));
        this.totalHomens = Long.valueOf(totalHomens);
        this.totalMulheres = Long.valueOf(totalMulheres);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public BigDecimal getPopulacaoTotal() {
        return populacaoTotal;
    }

    public void setPopulacaoTotal(BigDecimal populacaoTotal) {
        this.populacaoTotal = populacaoTotal;
    }

    public Long getTotalHomens() {
        return totalHomens;
    }

    public void setTotalHomens(Long totalHomens) {
        this.totalHomens = totalHomens;
    }

    public Long getTotalMulheres() {
        return totalMulheres;
    }

    public void setTotalMulheres(Long totalMulheres) {
        this.totalMulheres = totalMulheres;
    }
    
    @Override
    public boolean equals(Object obj){
    	return obj instanceof DadoPopulacional ? this.hashCode() == ((DadoPopulacional) obj).hashCode() : false; 
    }
    
    @Override
    public int hashCode(){
    	return Integer.valueOf(this.ano);
    }

	@Override
	public int compareTo(DadoPopulacional obj) {
		if(obj==null) throw new NullPointerException();
			if(this.equals(obj)) 
				return 0;
			else if(this.hashCode() > obj.hashCode()) 
				return 1;
			else
				return -1;
	}
	@Override
	public String toString(){
		return "["+this.id+","+this.ano+","+this.populacaoTotal+","+this.totalHomens+","+this.totalMulheres+"]";
	}
}