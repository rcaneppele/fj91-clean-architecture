package br.com.caelum.fj91.rh.domain.reajuste;

import java.util.List;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public interface ReajusteRepository {

	void salvar(Reajuste reajuste);

	Reajuste ultimoReajusteDoFuncionario(Funcionario funcionario);

	List<Reajuste> carregarReajustesDoFuncionario(Funcionario funcionario);

}
