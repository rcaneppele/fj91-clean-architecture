package br.com.caelum.fj91.rh.builders;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class CargoBuilder {

	private Long id;
	private String nome;
	private BigDecimal salarioMinimo;
	private BigDecimal salarioMaximo;
	
	public CargoBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public CargoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public CargoBuilder comSalarioMinimo(BigDecimal salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
		return this;
	}
	
	public CargoBuilder comSalarioMaximo(BigDecimal salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
		return this;
	}
	
	public Cargo build() {
		return new Cargo(id, nome, salarioMinimo, salarioMaximo);
	}
	
}
