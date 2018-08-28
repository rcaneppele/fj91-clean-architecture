package br.com.caelum.fj91.rh.persistencia.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
public class FuncionarioEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal salario;
	
	@ManyToOne
	private CargoEntity cargo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeAdmissao;
	
	//Hibernate only
	protected FuncionarioEntity() {
	}
	
	public FuncionarioEntity(String nome, BigDecimal salario, CargoEntity cargo, LocalDate dataDeAdmissao) {
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.dataDeAdmissao = dataDeAdmissao;
	}
	
	public FuncionarioEntity(Long id, String nome, BigDecimal salario, CargoEntity cargo, LocalDate dataDeAdmissao) {
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
		FuncionarioEntity other = (FuncionarioEntity) obj;
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
	public BigDecimal getSalario() {
		return salario;
	}
	public CargoEntity getCargo() {
		return cargo;
	}
	public LocalDate getDataDeAdmissao() {
		return dataDeAdmissao;
	}
	
}
