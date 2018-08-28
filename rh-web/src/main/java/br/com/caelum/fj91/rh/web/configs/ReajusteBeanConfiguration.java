package br.com.caelum.fj91.rh.web.configs;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.caelum.fj91.rh.domain.reajuste.ReajusteRepository;
import br.com.caelum.fj91.rh.usecases.reajuste.CadastroDeReajuste;
import br.com.caelum.fj91.rh.usecases.reajuste.ListagemDeReajustes;
import br.com.caelum.fj91.rh.usecases.reajuste.validacao.ValidadorPeriodicidadeReajustes;
import br.com.caelum.fj91.rh.usecases.reajuste.validacao.ValidadorPeriodoDeExperiencia;
import br.com.caelum.fj91.rh.usecases.reajuste.validacao.ValidadorReajuste;
import br.com.caelum.fj91.rh.usecases.reajuste.validacao.ValidadorReajusteDentroDaFaixaSalarial;

@Configuration
public class ReajusteBeanConfiguration {
	
	private final ReajusteRepository reajusteRepository;
	
	public ReajusteBeanConfiguration(ReajusteRepository reajusteRepository) {
		this.reajusteRepository = reajusteRepository;
	}

	@Bean
	public ListagemDeReajustes listagemDeReajustes() {
		return new ListagemDeReajustes(reajusteRepository);
	}
	
	@Bean
	public CadastroDeReajuste cadastroDeReajuste() {
		return new CadastroDeReajuste(validadoresCadastroReajuste(), reajusteRepository);
	}
	
	@Bean
	public List<ValidadorReajuste> validadoresCadastroReajuste() {
		return Arrays.asList(
				new ValidadorPeriodicidadeReajustes(reajusteRepository),
				new ValidadorPeriodoDeExperiencia(),
				new ValidadorReajusteDentroDaFaixaSalarial()
				);
	}
	
}