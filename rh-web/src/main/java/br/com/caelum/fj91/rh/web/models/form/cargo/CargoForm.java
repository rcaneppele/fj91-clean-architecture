package br.com.caelum.fj91.rh.web.models.form.cargo;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class CargoForm {
	
	private String nome;
	private BigDecimal salarioMinimo;
	private BigDecimal salarioMaximo;
	
	public Cargo toCargo() {
		return new Cargo(nome, salarioMinimo, salarioMaximo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getSalarioMinimo() {
		return salarioMinimo;
	}
	public void setSalarioMinimo(BigDecimal salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}
	public BigDecimal getSalarioMaximo() {
		return salarioMaximo;
	}
	public void setSalarioMaximo(BigDecimal salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

}
