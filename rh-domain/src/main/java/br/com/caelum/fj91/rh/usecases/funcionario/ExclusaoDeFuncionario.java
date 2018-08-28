package br.com.caelum.fj91.rh.usecases.funcionario;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;

public class ExclusaoDeFuncionario {
	
	private final FuncionarioRepository repository;
	
	public ExclusaoDeFuncionario(FuncionarioRepository repository) {
		this.repository = repository;
	}

	public void excluir(Funcionario funcionario) {
		repository.excluir(funcionario);
	}

}
