package br.com.caelum.fj91.rh.usecases.cargo;

import java.util.List;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;

public class ListagemDeCargos {
	
	private final CargoRepository repository;
	
	public ListagemDeCargos(CargoRepository repository) {
		this.repository = repository;
	}

	public List<Cargo> listar() {
		return repository.carregarTodos();
	}

}
