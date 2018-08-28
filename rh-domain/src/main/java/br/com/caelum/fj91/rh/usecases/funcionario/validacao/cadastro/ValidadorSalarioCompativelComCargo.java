package br.com.caelum.fj91.rh.usecases.funcionario.validacao.cadastro;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public class ValidadorSalarioCompativelComCargo implements ValidadorCadastroFuncionario {
	
	private final CargoRepository cargoRepository;
	
	public ValidadorSalarioCompativelComCargo(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Override
	public void validar(Funcionario funcionario) {
		Cargo cargoDoFuncionario = cargoRepository.buscarPorId(funcionario.getCargo().getId());
		BigDecimal salarioDoFuncionario = funcionario.getSalario();
		BigDecimal salarioMinimoDoCargo = cargoDoFuncionario.getSalarioMinimo();
		BigDecimal salarioMaximoDoCargo = cargoDoFuncionario.getSalarioMaximo();
		
		if (salarioDoFuncionario.compareTo(salarioMinimoDoCargo) < 0) {
			throw new BusinessException("Salário do funcionário não pode ser menor do que o salário mínimo de seu cargo");
		}
		
		if (salarioDoFuncionario.compareTo(salarioMaximoDoCargo) > 0) {
			throw new BusinessException("Salário do funcionário não pode ser maior do que salário máximo de seu cargo");
		}
	}

}
