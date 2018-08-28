package br.com.caelum.fj91.rh.web.models.view.cargo;

import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class ListaDeCargosViewModel {
	
	private final List<CargoViewModel> cargos;

	public ListaDeCargosViewModel(List<Cargo> cargos) {
		this.cargos = cargos.stream().map(c -> new CargoViewModel(c)).collect(Collectors.toList());
	}
	
	public List<CargoViewModel> getCargos() {
		return cargos;
	}

}
