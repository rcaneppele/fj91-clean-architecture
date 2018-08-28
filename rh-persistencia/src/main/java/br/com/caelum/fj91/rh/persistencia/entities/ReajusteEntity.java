package br.com.caelum.fj91.rh.persistencia.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Reajuste")
@Table(name = "reajuste")
public class ReajusteEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	private String motivo;
	private LocalDate data;
	
	@ManyToOne
	private FuncionarioEntity funcionario;
	
	//Hibernate only
	protected ReajusteEntity() {
	}

	public ReajusteEntity(BigDecimal valor, String motivo, LocalDate data, FuncionarioEntity funcionario) {
		this.valor = valor;
		this.motivo = motivo;
		this.data = data;
		this.funcionario = funcionario;
	}
	
	public ReajusteEntity(Long id, BigDecimal valor, String motivo, LocalDate data, FuncionarioEntity funcionario) {
		this.id = id;
		this.valor = valor;
		this.motivo = motivo;
		this.data = data;
		this.funcionario = funcionario;
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
		ReajusteEntity other = (ReajusteEntity) obj;
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
	public BigDecimal getValor() {
		return valor;
	}
	public String getMotivo() {
		return motivo;
	}
	public LocalDate getData() {
		return data;
	}
	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}
	
}
