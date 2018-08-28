package br.com.caelum.fj91.rh.usecases.reajuste.validacao;

import java.time.Period;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.domain.reajuste.ReajusteRepository;

public class ValidadorPeriodicidadeReajustes implements ValidadorReajuste {
	
	private final ReajusteRepository repository;
	
	public ValidadorPeriodicidadeReajustes(ReajusteRepository repository) {
		this.repository = repository;
	}

	@Override
	public void validar(Reajuste reajuste) {
		Reajuste ultimoRecebido = repository.ultimoReajusteDoFuncionario(reajuste.getFuncionario());
		
		//se o funcionario nunca teve reajustes 
		if (ultimoRecebido == null) {
			return;
		}
		
		Period intervaloEntreReajustes = ultimoRecebido.getData().until(reajuste.getData());
		if (intervaloEntreReajustes.getYears() < 1 && intervaloEntreReajustes.getMonths() < 6) {
			throw new BusinessException("Funcionário não pode receber reajuste pois recebeu outro há menos de 6 meses");
		}
	}
	
}
