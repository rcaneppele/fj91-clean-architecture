package br.com.caelum.fj91.rh.web.models.view.cargo;

import java.math.BigDecimal;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class CargoViewModel {
	
	private final Long id;
	private final String nome;
	private final BigDecimal salarioMinimo;
	private final BigDecimal salarioMaximo;

	public CargoViewModel(Cargo cargo) {
		this.id = cargo.getId();
		this.nome = cargo.getNome();
		this.salarioMinimo = cargo.getSalarioMinimo();
		this.salarioMaximo = cargo.getSalarioMaximo();
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getSalarioMinimo() {
		return salarioMinimo;
	}
	public BigDecimal getSalarioMaximo() {
		return salarioMaximo;
	}

}
