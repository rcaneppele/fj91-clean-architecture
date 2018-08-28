package br.com.caelum.fj91.rh.web.models.view.reajuste;

import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;

public class ListaDeReajustesViewModel {
	
	private final List<ReajusteViewModel> reajustes;
	private final Funcionario funcionario;

	public ListaDeReajustesViewModel(List<Reajuste> reajustes, Funcionario funcionario) {
		this.funcionario = funcionario;
		this.reajustes = reajustes.stream().map(r -> new ReajusteViewModel(r)).collect(Collectors.toList());
	}
	
	public List<ReajusteViewModel> getReajustes() {
		return reajustes;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

}
