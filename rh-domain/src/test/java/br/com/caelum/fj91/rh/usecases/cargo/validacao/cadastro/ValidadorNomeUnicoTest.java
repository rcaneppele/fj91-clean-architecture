package br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.fj91.rh.builders.CargoBuilder;
import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;

@RunWith(MockitoJUnitRunner.class)
public class ValidadorNomeUnicoTest {
	
	@Mock
	private CargoRepository repository;
	private ValidadorNomeUnico validador;
	private Cargo gerente;
	
	@Before
	public void setup() {
		this.validador = new ValidadorNomeUnico(repository);
		this.gerente = new CargoBuilder().comNome("Gerente").build();
	}
	
	@Test
	public void devePermitirCadastrarCargoCasoSeuNomeSejaUnico() {
		Mockito.when(repository.jaEstaCadastrado(gerente.getNome())).thenReturn(false);
		validador.validar(gerente);
	}
	
	@Test(expected = BusinessException.class)
	public void naoDevePermitirCadastrarCargoComMesmoNomeDeOutroCargo() {
		Mockito.when(repository.jaEstaCadastrado(gerente.getNome())).thenReturn(true);
		validador.validar(gerente);
	}

}
