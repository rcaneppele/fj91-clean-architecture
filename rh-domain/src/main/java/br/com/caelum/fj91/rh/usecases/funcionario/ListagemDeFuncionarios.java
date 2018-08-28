package br.com.caelum.fj91.rh.usecases.funcionario;

import java.util.List;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;

public class ListagemDeFuncionarios {
	
	private final FuncionarioRepository repository;
	
	public ListagemDeFuncionarios(FuncionarioRepository repository) {
		this.repository = repository;
	}

	public List<Funcionario> listar() {
		return repository.carregarTodos();
	}

}
