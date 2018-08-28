package br.com.caelum.fj91.rh.usecases.funcionario;

import java.util.List;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;
import br.com.caelum.fj91.rh.usecases.funcionario.validacao.cadastro.ValidadorCadastroFuncionario;

public class CadastroDeFuncionario {
	
	private final List<ValidadorCadastroFuncionario> validacoes;
	private final FuncionarioRepository repository;
	
	public CadastroDeFuncionario(List<ValidadorCadastroFuncionario> validacoes, FuncionarioRepository repository) {
		this.validacoes = validacoes;
		this.repository = repository;
	}

	public void cadastrar(Funcionario novo) {
		validacoes.forEach(v -> v.validar(novo));
		repository.salvar(novo);
	}

}
