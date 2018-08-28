package br.com.caelum.fj91.rh.usecases.cargo;

import java.util.List;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.exclusao.ValidadorExclusaoCargo;

public class ExclusaoDeCargo {
	
	private final List<ValidadorExclusaoCargo> validacoes;
	private final CargoRepository repository;
	
	public ExclusaoDeCargo(List<ValidadorExclusaoCargo> validacoes, CargoRepository repository) {
		this.validacoes = validacoes;
		this.repository = repository;
	}

	public void excluir(Cargo cargo) {
		validacoes.forEach(v -> v.validar(cargo));
		repository.excluir(cargo);
	}

}
