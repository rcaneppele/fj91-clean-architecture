package br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;

public class ValidadorNomeUnico implements ValidadorCadastroCargo {
	
	private final CargoRepository repository;
	
	public ValidadorNomeUnico(CargoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void validar(Cargo cargo) {
		boolean existeOutroComMesmoNome = repository.jaEstaCadastrado(cargo.getNome());
		if (existeOutroComMesmoNome) {
			throw new BusinessException("Já existe outro cargo cadastrado com esse nome");
		}
	}

}
