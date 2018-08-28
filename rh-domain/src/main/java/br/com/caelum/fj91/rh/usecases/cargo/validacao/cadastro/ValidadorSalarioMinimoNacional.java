package br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class ValidadorSalarioMinimoNacional implements ValidadorCadastroCargo {
	
	private static final BigDecimal SALARIO_MINIMO_NACIONAL = new BigDecimal("954.00");

	@Override
	public void validar(Cargo cargo) {
		if (cargo.getSalarioMinimo().compareTo(SALARIO_MINIMO_NACIONAL) < 0) {
			throw new BusinessException("Salário mínimo do cargo nao pode ser menor do que o salário mínimo nacional(R$954,00)");
		}
	}

}
