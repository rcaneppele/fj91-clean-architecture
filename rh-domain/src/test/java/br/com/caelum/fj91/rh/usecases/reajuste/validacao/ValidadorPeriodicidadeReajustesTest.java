package br.com.caelum.fj91.rh.usecases.reajuste.validacao;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.fj91.rh.builders.FuncionarioBuilder;
import br.com.caelum.fj91.rh.builders.ReajusteBuilder;
import br.com.caelum.fj91.rh.domain.BusinessException;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.domain.reajuste.ReajusteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ValidadorPeriodicidadeReajustesTest {
	
	@Mock
	private ReajusteRepository repository;
	private ValidadorPeriodicidadeReajustes validador;
	private ReajusteBuilder builder;
	private Funcionario joao;
	private Reajuste bonus;
	
	@Before
	public void setup() {
		this.validador = new ValidadorPeriodicidadeReajustes(repository);
		this.builder = new ReajusteBuilder();
		this.joao = new FuncionarioBuilder().build();
		this.bonus = builder.comFuncionario(joao).comData(LocalDate.now()).build();
	}

	@Test(expected = BusinessException.class)
	public void funcionarioNaoPodeReceberReajusteSeTiverRecebidoOutroHaMenosDe6Meses() {
		Reajuste doMesPassado = builder.comFuncionario(joao).comData(LocalDate.now().minusMonths(1)).build();
		Mockito.when(repository.ultimoReajusteDoFuncionario(joao)).thenReturn(doMesPassado);
		
		validador.validar(bonus);
	}
	
	@Test
	public void funcionarioPodeReceberReajusteSeTiverRecebidoOutroHaExatos6Meses() {
		Reajuste de6MesesAtras = builder.comFuncionario(joao).comData(LocalDate.now().minusMonths(6)).build();
		Mockito.when(repository.ultimoReajusteDoFuncionario(joao)).thenReturn(de6MesesAtras);
		
		validador.validar(bonus);
	}
	
	@Test
	public void funcionarioPodeReceberReajusteSeTiverRecebidoOutroHaMaisDe6Meses() {
		Reajuste de1AnoAtras = builder.comFuncionario(joao).comData(LocalDate.now().minusYears(1)).build();
		Mockito.when(repository.ultimoReajusteDoFuncionario(joao)).thenReturn(de1AnoAtras);
		
		validador.validar(bonus);
	}
	
	@Test
	public void funcionarioQueNuncaRecebeuReajustesPodeReceberPrimeiroReajuste() {
		Mockito.when(repository.ultimoReajusteDoFuncionario(joao)).thenReturn(null);

		validador.validar(bonus);
	}

}
