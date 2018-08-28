package br.com.caelum.fj91.rh.domain.funcionario;

import java.util.List;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public interface FuncionarioRepository {

	boolean existeAlgumComCargo(Cargo cargo);

	List<Funcionario> carregarTodos();

	void salvar(Funcionario funcionario);

	void excluir(Funcionario funcionario);

	Funcionario buscarPorId(Long id);

}
