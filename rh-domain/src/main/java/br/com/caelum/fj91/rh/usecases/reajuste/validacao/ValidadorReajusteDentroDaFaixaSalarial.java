package br.com.caelum.fj91.rh.usecases.reajuste.validacao;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;

public class ValidadorReajusteDentroDaFaixaSalarial implements ValidadorReajuste {

	@Override
	public void validar(Reajuste reajuste) {
		BigDecimal salarioAtual = reajuste.getFuncionario().getSalario();
		BigDecimal salarioReajustado = salarioAtual.add(reajuste.getValor());
		BigDecimal salarioMaximoDoCargo = reajuste.getFuncionario().getCargo().getSalarioMaximo();

		if (salarioReajustado.compareTo(salarioMaximoDoCargo) > 0) {
			throw new BusinessException("Salário reajustado do funcionário não pode ultrapassar o valor do salário máximo de seu cargo");
		}
	}

}
