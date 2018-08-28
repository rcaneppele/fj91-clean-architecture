package br.com.caelum.fj91.rh.web.models.view.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;

public class ReajusteViewModel {
	
	private Long id;
	private BigDecimal valor;
	private String motivo;
	private LocalDate data;

	public ReajusteViewModel(Reajuste reajuste) {
		this.id = reajuste.getId();
		this.valor = reajuste.getValor();
		this.motivo = reajuste.getMotivo();
		this.data = reajuste.getData();
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

}
