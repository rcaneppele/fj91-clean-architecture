package br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class ValidadorSalarioMinimoMenorQueMaximo implements ValidadorCadastroCargo {
	
	@Override
	public void validar(Cargo cargo) {
		if (cargo.getSalarioMinimo().compareTo(cargo.getSalarioMaximo()) > 0) {
			throw new BusinessException("Salário mínimo deve ser menor do que o salário máximo");
		}
	}

}
