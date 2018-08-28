package br.com.caelum.fj91.rh.persistencia.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Cargo")
@Table(name = "cargo")
public class CargoEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal salarioMinimo;
	private BigDecimal salarioMaximo;
	
	//Hibernate only
	protected CargoEntity() {
	}

	public CargoEntity(String nome, BigDecimal salarioMinimo, BigDecimal salarioMaximo) {
		this.nome = nome;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
	}
	
	public CargoEntity(Long id, String nome, BigDecimal salarioMinimo, BigDecimal salarioMaximo) {
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
		CargoEntity other = (CargoEntity) obj;
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
