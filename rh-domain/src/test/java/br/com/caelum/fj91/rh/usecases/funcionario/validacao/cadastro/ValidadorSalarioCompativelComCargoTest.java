package br.com.caelum.fj91.rh.usecases.funcionario.validacao.cadastro;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.fj91.rh.builders.CargoBuilder;
import br.com.caelum.fj91.rh.builders.FuncionarioBuilder;
import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

@RunWith(MockitoJUnitRunner.class)
public class ValidadorSalarioCompativelComCargoTest {
	
	@Mock	
	private CargoRepository cargoRepository;
	private ValidadorSalarioCompativelComCargo validador;
	private Cargo gerente;
	
	@Before
	public void setup() {
		this.validador = new ValidadorSalarioCompativelComCargo(this.cargoRepository);
		this.gerente = new CargoBuilder().comSalarioMinimo(new BigDecimal("5000")).comSalarioMaximo(new BigDecimal("8000")).build();
		Mockito.when(cargoRepository.buscarPorId(gerente.getId())).thenReturn(gerente);
	}
	
	@Test(expected = BusinessException.class)
	public void salarioDoFuncionarioNaoPodeSerMenorQueSalarioMinimoDeSeuCargo() {
		Funcionario joao = criaFuncionario(new BigDecimal("1000"));
		validador.validar(joao);
	}
	
	@Test(expected = BusinessException.class)
	public void salarioDoFuncionarioNaoPodeSerMaiorQueSalarioMaximoDeSeuCargo() {
		Funcionario joao = criaFuncionario(new BigDecimal("9000"));
		validador.validar(joao);
	}
	
	@Test
	public void salarioDoFuncionarioPodeSerIgualAoSalarioMinimoDeSeuCargo() {
		Funcionario joao = criaFuncionario(new BigDecimal("5000"));
		validador.validar(joao);
	}
	
	@Test
	public void salarioDoFuncionarioPodeSerIgualAoSalarioMaximoDeSeuCargo() {
		Funcionario joao = criaFuncionario(new BigDecimal("8000"));
		validador.validar(joao);
	}
	
	@Test
	public void salarioDoFuncionarioPodeTerValorQueEstejaEntreAFaixaSalarialDeSeuCargo() {
		Funcionario joao = criaFuncionario(new BigDecimal("7500"));
		validador.validar(joao);
	}
	
	private Funcionario criaFuncionario(BigDecimal salario) {
		return new FuncionarioBuilder().comCargo(gerente).comSalario(salario).build();
	}
	
}
