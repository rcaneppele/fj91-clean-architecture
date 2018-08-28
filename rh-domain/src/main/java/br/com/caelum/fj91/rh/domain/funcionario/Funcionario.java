package br.com.caelum.fj91.rh.domain.funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;

public class Funcionario {

	private Long id;
	private String nome;
	private BigDecimal salario;
	private Cargo cargo;
	private LocalDate dataDeAdmissao;
	
	public Funcionario(String nome, BigDecimal salario, Cargo cargo, LocalDate dataDeAdmissao) {
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public Funcionario(Long id, String nome, BigDecimal salario, Cargo cargo, LocalDate dataDeAdmissao) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.dataDeAdmissao = dataDeAdmissao;
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
		Funcionario other = (Funcionario) obj;
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
	public Cargo getCargo() {
		return cargo;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public LocalDate getDataDeAdmissao() {
		return dataDeAdmissao;
	}

}
