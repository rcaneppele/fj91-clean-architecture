package br.com.caelum.fj91.rh.usecases.reajuste;

import java.util.List;

import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.domain.reajuste.ReajusteRepository;
import br.com.caelum.fj91.rh.usecases.reajuste.validacao.ValidadorReajuste;

public class CadastroDeReajuste {
	
	private final List<ValidadorReajuste> validacoes;
	private final ReajusteRepository repository;

	public CadastroDeReajuste(List<ValidadorReajuste> validacoes, ReajusteRepository repository) {
		this.validacoes = validacoes;
		this.repository = repository;
	}
	
	public void reajustarSalarioDoFuncionario(Reajuste reajuste) {
		validacoes.forEach(v -> v.validar(reajuste));
		repository.salvar(reajuste);
	}

}
