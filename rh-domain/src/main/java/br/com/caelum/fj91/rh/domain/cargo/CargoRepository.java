package br.com.caelum.fj91.rh.domain.cargo;

import java.util.List;

public interface CargoRepository {
	
	void salvar(Cargo cargo);
	boolean jaEstaCadastrado(String nome);
	void excluir(Cargo cargo);
	List<Cargo> carregarTodos();
	Cargo buscarPorId(Long id);

}
