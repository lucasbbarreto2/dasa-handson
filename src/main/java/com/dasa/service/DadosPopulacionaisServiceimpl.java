package com.dasa.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.DadosPopulacionaisRepository;

@Service
public class DadosPopulacionaisServiceimpl implements DadosPopulacionaisService {

    @Autowired
    private DadosPopulacionaisRepository dadosPopulacionaisRepository;

    @Override
    public DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano) {

        final String anoCenso = ano.get();

        if (!ano.isPresent()) {
            throw new IllegalArgumentException("Parametro Ano é Obrigatório");
        }
        if(dadosPopulacionaisRepository.findByAno(anoCenso)==null){
        	calculaProgressao(ano.get());
        }

        return dadosPopulacionaisRepository.findByAno(anoCenso);
    }
    private void calculaProgressao(String ano){
    	
    	if((Integer.parseInt(ano))>2017) 
    		throw new IllegalArgumentException("Data fim para requisção 2017");
    
    	String anoInicio = String.valueOf(Integer.parseInt(ano)-10);
		String anoFim = String.valueOf(Integer.parseInt(ano)-1); 
		List<DadoPopulacional> lista = dadosPopulacionaisRepository.findAll();
		lista.sort((dp1, dp2) -> dp1.compareTo(dp2));
		DadoPopulacional dadoInicioPeriodo = lista.get(lista.indexOf(
				 dadosPopulacionaisRepository.findByAno(anoInicio)));
		DadoPopulacional dadoFimPeriodo = lista.get(lista.indexOf(
			 dadosPopulacionaisRepository.findByAno(anoFim)));
		
		BigDecimal popHomemInicioPeriodo = BigDecimal.valueOf(dadoInicioPeriodo.getTotalHomens());
		BigDecimal popHomemFimPeriodo = BigDecimal.valueOf(dadoFimPeriodo.getTotalHomens());
		BigDecimal progressaoHomem = popHomemFimPeriodo.divide(popHomemInicioPeriodo, 10, BigDecimal.ROUND_HALF_UP);
		progressaoHomem = powerBig(progressaoHomem, new BigDecimal(0.1));
		progressaoHomem = progressaoHomem.subtract(BigDecimal.ONE);
		BigDecimal totalHomensAno = progressaoHomem.multiply(popHomemFimPeriodo);
		
		BigDecimal popMulherInicioPeriodo = BigDecimal.valueOf(dadoInicioPeriodo.getTotalMulheres());
		BigDecimal popMulherFimPeriodo = BigDecimal.valueOf(dadoFimPeriodo.getTotalMulheres());
		BigDecimal progressaoMulher = popMulherFimPeriodo.divide(popMulherInicioPeriodo,10, BigDecimal.ROUND_HALF_UP);
		progressaoMulher =	powerBig(progressaoMulher, new BigDecimal(0.1));
		progressaoMulher = progressaoMulher.subtract(BigDecimal.ONE);
		BigDecimal totalMulheresAno = progressaoMulher.multiply(popMulherFimPeriodo);
	
		
		dadosPopulacionaisRepository.save(new DadoPopulacional(ano, totalHomensAno.add(totalMulheresAno).setScale(0, RoundingMode.HALF_EVEN).toString(),
											totalHomensAno.round(MathContext.DECIMAL32).toString(),totalMulheresAno.round(MathContext.DECIMAL32).toString() ));
    }
   private BigDecimal powerBig(BigDecimal base, BigDecimal exponent) {

        BigDecimal ans=  new BigDecimal(1.0);
        BigDecimal k=  new BigDecimal(1.0);
        BigDecimal t=  new BigDecimal(-1.0);
        BigDecimal no=  new BigDecimal(0.0);

        if (exponent != no) {
            BigDecimal absExponent =  exponent.signum() > 0 ? exponent : t.multiply(exponent);
            while (absExponent.signum() > 0){
                ans =ans.multiply(base);
                absExponent = absExponent.subtract(BigDecimal.ONE);
            }

            if (exponent.signum() < 0) {
                ans = k.divide(ans);
            }
        } else {
            ans = k;
        }

        return ans;
    }
}
