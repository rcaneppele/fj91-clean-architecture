package br.com.caelum.fj91.rh.domain.cargo;

import java.math.BigDecimal;

public class Cargo {

	private Long id;
	private String nome;
	private BigDecimal salarioMinimo;
	private BigDecimal salarioMaximo;
	
	public Cargo(String nome, BigDecimal salarioMinimo, BigDecimal salarioMaximo) {
		this.nome = nome;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
	}
	
	public Cargo(Long id, String nome, BigDecimal salarioMinimo, BigDecimal salarioMaximo) {
		this.id = id;
		this.nome = nome;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
