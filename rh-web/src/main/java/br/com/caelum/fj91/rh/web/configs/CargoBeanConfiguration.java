package br.com.caelum.fj91.rh.web.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;
import br.com.caelum.fj91.rh.usecases.cargo.CadastroDeCargo;
import br.com.caelum.fj91.rh.usecases.cargo.ExclusaoDeCargo;
import br.com.caelum.fj91.rh.usecases.cargo.ListagemDeCargos;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro.ValidadorCadastroCargo;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro.ValidadorNomeUnico;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro.ValidadorSalarioMaximoEmpresa;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro.ValidadorSalarioMinimoMenorQueMaximo;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.cadastro.ValidadorSalarioMinimoNacional;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.exclusao.ValidadorCargoEmUso;
import br.com.caelum.fj91.rh.usecases.cargo.validacao.exclusao.ValidadorExclusaoCargo;

@Configuration
public class CargoBeanConfiguration {
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	
	public CargoBeanConfiguration(CargoRepository cargoRepository, FuncionarioRepository funcionarioRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	@Bean
	public ListagemDeCargos listagemDeCargos() {
		return new ListagemDeCargos(cargoRepository);
	}
	
	@Bean
	public CadastroDeCargo cadastroDeCargo() {
		return new CadastroDeCargo(validadoresCadastroCargo(), cargoRepository);
	}
	
	@Bean
	public ExclusaoDeCargo exclusaoDeCargo() {
		return new ExclusaoDeCargo(validadoresExclusaoCargo(), cargoRepository);
	}
	
	@Bean
	public List<ValidadorCadastroCargo> validadoresCadastroCargo() {
		return Arrays.asList(
				new ValidadorNomeUnico(cargoRepository),
				new ValidadorSalarioMaximoEmpresa(),
				new ValidadorSalarioMinimoMenorQueMaximo(),
				new ValidadorSalarioMinimoNacional()
				);
	}
	
	@Bean
	public List<ValidadorExclusaoCargo> validadoresExclusaoCargo() {
		return Arrays.asList(
				new ValidadorCargoEmUso(funcionarioRepository)
				);
	}
	
}