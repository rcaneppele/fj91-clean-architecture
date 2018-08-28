package br.com.caelum.fj91.rh.usecases.cargo;

import java.util.List;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro.ValidadorCadastroCargo;

public class CadastroDeCargo {
	
	private final List<ValidadorCadastroCargo> validacoes;
	private final CargoRepository repository;
	
	public CadastroDeCargo(List<ValidadorCadastroCargo> validacoes, CargoRepository repository) {
		this.validacoes = validacoes;
		this.repository = repository;
	}

	public void cadastrar(Cargo novo) {
		validacoes.forEach(v -> v.validar(novo));
		repository.salvar(novo);
	}

}
