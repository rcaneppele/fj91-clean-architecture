package br.com.caelum.fj91.rh.builders;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public class FuncionarioBuilder {

	private Long id;
	private String nome;
	private BigDecimal salario;
	private Cargo cargo;
	private LocalDate dataDeAdmissao;
	
	public FuncionarioBuilder comId(Long id) {
		this.id = id;
		return this;
	}
	
	public FuncionarioBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public FuncionarioBuilder comSalario(BigDecimal salario) {
		this.salario = salario;
		return this;
	}
	
	public FuncionarioBuilder comCargo(Cargo cargo) {
		this.cargo = cargo;
		return this;
	}
	
	public FuncionarioBuilder comDataDeAdmissao(LocalDate dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
		return this;
	}
	
	public Funcionario build() {
		return new Funcionario(id, nome, salario, cargo, dataDeAdmissao);
	}
	
}
