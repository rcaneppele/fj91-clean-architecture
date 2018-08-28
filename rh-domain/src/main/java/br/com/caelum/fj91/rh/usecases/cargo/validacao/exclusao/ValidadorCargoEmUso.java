package br.com.caelum.fj91.rh.usecases.cargo.validacao.exclusao;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;

public class ValidadorCargoEmUso implements ValidadorExclusaoCargo {
	
	private final FuncionarioRepository repository;

	public ValidadorCargoEmUso(FuncionarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public void validar(Cargo cargo) {
		boolean cargoEstaEmUso = repository.existeAlgumComCargo(cargo);
		if (cargoEstaEmUso) {
			throw new BusinessException("Cargo não pode ser excluído pois está atributido a algum funcionário");
		}
	}
	
}
