package br.com.caelum.fj91.rh.domain.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public class Reajuste {
	
	private Long id;
	private BigDecimal valor;
	private String motivo;
	private LocalDate data;
	private Funcionario funcionario;
	
	public Reajuste(BigDecimal valor, String motivo, LocalDate data, Funcionario funcionario) {
		this.valor = valor;
		this.motivo = motivo;
		this.data = data;
		this.funcionario = funcionario;
	}

	public Reajuste(Long id, BigDecimal valor, String motivo, LocalDate data, Funcionario funcionario) {
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
		Reajuste other = (Reajuste) obj;
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
	public LocalDate getData() {
		return data;
	}
	public String getMotivo() {
		return motivo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

}
