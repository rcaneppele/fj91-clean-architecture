package br.com.caelum.fj91.rh.usecases.reajuste.validacao;

import java.time.LocalDate;
import java.time.Period;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;

public class ValidadorPeriodoDeExperiencia implements ValidadorReajuste {
	
	@Override
	public void validar(Reajuste reajuste) {
		LocalDate dataAdmissao = reajuste.getFuncionario().getDataDeAdmissao();
		LocalDate dataReajuste = reajuste.getData();
		
		Period intervaloEntreAdmissaoEReajuste = dataAdmissao.until(dataReajuste);
		if (intervaloEntreAdmissaoEReajuste.getYears() < 1 && intervaloEntreAdmissaoEReajuste.getMonths() < 3) {
			throw new BusinessException("Funcionário em período de experiência não pode receber reajuste");
		}
	}

}
