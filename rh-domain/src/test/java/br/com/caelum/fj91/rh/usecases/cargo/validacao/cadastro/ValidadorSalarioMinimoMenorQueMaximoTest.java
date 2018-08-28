package br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.fj91.rh.builders.CargoBuilder;
import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class ValidadorSalarioMinimoMenorQueMaximoTest {

	private ValidadorSalarioMinimoMenorQueMaximo validador;
	private CargoBuilder builder;
	
	@Before
	public void setup() {
		validador = new ValidadorSalarioMinimoMenorQueMaximo();
		this.builder = new CargoBuilder();
	}

	@Test(expected = BusinessException.class)
	public void salarioMinimoNaoPodeSerMaiorDoQueSalarioMaximo() {
		Cargo gerente = builder.comSalarioMinimo(new BigDecimal("9000.00")).comSalarioMaximo(new BigDecimal("8000.00")).build();
		validador.validar(gerente);
	}

	@Test
	public void salarioMinimoPodeSerIgualAoSalarioMaximo() {
		Cargo gerente = builder.comSalarioMinimo(new BigDecimal("8000.00")).comSalarioMaximo(new BigDecimal("8000.00")).build();
		validador.validar(gerente);
	}
	
	@Test
	public void salarioMinimoPodeSerMenorDoQueSalarioMaximo() {
		Cargo gerente = builder.comSalarioMinimo(new BigDecimal("7000.00")).comSalarioMaximo(new BigDecimal("8000.00")).build();
		validador.validar(gerente);
	}

}
