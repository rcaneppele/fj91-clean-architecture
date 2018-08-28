package br.com.caelum.fj91.rh.web.models.form.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;

public class ReajusteForm {
	
	private BigDecimal valor;
	private String motivo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	public Reajuste toReajuste(Funcionario funcionario) {
		return new Reajuste(valor, motivo, data, funcionario);
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getData() {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
