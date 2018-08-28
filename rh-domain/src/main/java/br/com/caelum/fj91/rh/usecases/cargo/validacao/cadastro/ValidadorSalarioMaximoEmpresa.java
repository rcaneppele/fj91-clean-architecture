package br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class ValidadorSalarioMaximoEmpresa implements ValidadorCadastroCargo {
	
	private static final BigDecimal SALARIO_MAXIMO_EMPRESA = new BigDecimal("100000.00");

	@Override
	public void validar(Cargo cargo) {
		if (cargo.getSalarioMaximo().compareTo(SALARIO_MAXIMO_EMPRESA) > 0) {
			throw new BusinessException("Salário máximo do cargo não pode ser maior do que R$100.000,00");
		}
	}

}
