package br.com.caelum.fj91.rh.web.models.form.funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;

public class FuncionarioForm {
	
	private String nome;
	private BigDecimal salario;
	private Long idCargo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeAdmissao;
	
	public Funcionario toFuncionario() {
		Cargo cargo = new Cargo(idCargo, null, null, null);
		return new Funcionario(nome, salario, cargo, dataDeAdmissao);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}
	public String getDataDeAdmissao() {
		return dataDeAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

}
