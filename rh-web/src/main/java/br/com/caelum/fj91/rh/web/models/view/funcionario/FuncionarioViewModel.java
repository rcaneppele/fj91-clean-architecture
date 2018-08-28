package br.com.caelum.fj91.rh.web.models.view.funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public class FuncionarioViewModel {
	
	private final Long id;
	private final String nome;
	private final BigDecimal salario;
	private final Cargo cargo;
	private final LocalDate dataDeAdmissao;

	public FuncionarioViewModel(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.salario = funcionario.getSalario();
		this.cargo = funcionario.getCargo();
		this.dataDeAdmissao = funcionario.getDataDeAdmissao();
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
	public Cargo getCargo() {
		return cargo;
	}
	public LocalDate getDataDeAdmissao() {
		return dataDeAdmissao;
	}

}
