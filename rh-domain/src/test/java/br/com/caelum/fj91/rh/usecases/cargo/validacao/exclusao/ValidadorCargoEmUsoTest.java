package br.com.caelum.fj91.rh.usecases.cargo.validacao.exclusao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.fj91.rh.builders.CargoBuilder;
import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class ValidadorCargoEmUsoTest {

	@Mock
	private FuncionarioRepository repository;
	private ValidadorCargoEmUso validador;
	private Cargo gerente;
	
	@Before
	public void setup() {
		this.validador = new ValidadorCargoEmUso(repository);
		this.gerente = new CargoBuilder().comNome("Gerente").build();
	}
	
	@Test
	public void devePermitirExcluirCargoQueNaoTemFuncionarioVinculado() {
		Mockito.when(repository.existeAlgumComCargo(gerente)).thenReturn(false);
		validador.validar(gerente);
	}
	
	@Test(expected = BusinessException.class)
	public void naoDevePermitirExcluirCargoQueTemFuncionarioVinculado() {
		Mockito.when(repository.existeAlgumComCargo(gerente)).thenReturn(true);
		validador.validar(gerente);
	}

}
