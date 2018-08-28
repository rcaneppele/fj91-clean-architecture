package br.com.caelum.fj91.rh.web.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;
import br.com.caelum.fj91.rh.usecases.funcionario.CadastroDeFuncionario;
import br.com.caelum.fj91.rh.usecases.funcionario.ExclusaoDeFuncionario;
import br.com.caelum.fj91.rh.usecases.funcionario.ListagemDeFuncionarios;
import br.com.caelum.fj91.rh.usecases.funcionario.validacao.cadastro.ValidadorCadastroFuncionario;
import br.com.caelum.fj91.rh.usecases.funcionario.validacao.cadastro.ValidadorSalarioCompativelComCargo;

@Configuration
public class FuncionarioBeanConfiguration {
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioBeanConfiguration(CargoRepository cargoRepository, FuncionarioRepository funcionarioRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	@Bean
	public ListagemDeFuncionarios listagemDeFuncionarios() {
		return new ListagemDeFuncionarios(funcionarioRepository);
	}
	
	@Bean
	public CadastroDeFuncionario cadastroDeFuncionario() {
		return new CadastroDeFuncionario(validadoresCadastroFuncionario(), funcionarioRepository);
	}
	
	@Bean
	public ExclusaoDeFuncionario exclusaoDeFuncionario() {
		return new ExclusaoDeFuncionario(funcionarioRepository);
	}
	
	@Bean
	public List<ValidadorCadastroFuncionario> validadoresCadastroFuncionario() {
		return Arrays.asList(
				new ValidadorSalarioCompativelComCargo(cargoRepository)
				);
	}
	
}