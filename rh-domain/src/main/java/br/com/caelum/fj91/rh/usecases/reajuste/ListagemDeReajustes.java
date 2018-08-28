package br.com.caelum.fj91.rh.usecases.reajuste;

import java.util.List;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.domain.reajuste.ReajusteRepository;

public class ListagemDeReajustes {
	
	private final ReajusteRepository repository;
	
	public ListagemDeReajustes(ReajusteRepository repository) {
		this.repository = repository;
	}

	public List<Reajuste> listar(Funcionario funcionario) {
		return repository.carregarReajustesDoFuncionario(funcionario);
	}

}
