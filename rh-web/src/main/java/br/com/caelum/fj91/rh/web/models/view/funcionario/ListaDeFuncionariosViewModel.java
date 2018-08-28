package br.com.caelum.fj91.rh.web.models.view.funcionario;

import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public class ListaDeFuncionariosViewModel {
	
	private final List<FuncionarioViewModel> funcionarios;

	public ListaDeFuncionariosViewModel(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios.stream().map(f -> new FuncionarioViewModel(f)).collect(Collectors.toList());
	}
	
	public List<FuncionarioViewModel> getFuncionarios() {
		return funcionarios;
	}

}
