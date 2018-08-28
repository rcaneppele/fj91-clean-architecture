package br.com.caelum.fj91.rh.builders;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;

public class ReajusteBuilder {

	private Long id;
	private BigDecimal valor;
	private String motivo;
	private LocalDate data;
	private Funcionario funcionario;
	
	public ReajusteBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public ReajusteBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}
	
	public ReajusteBuilder comMotivo(String motivo) {
		this.motivo = motivo;
		return this;
	}
	
	public ReajusteBuilder comData(LocalDate data) {
		this.data = data;
		return this;
	}
	
	public ReajusteBuilder comFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		return this;
	}
	
	public Reajuste build() {
		return new Reajuste(id, valor, motivo, data, funcionario);
	}
	
}
