package br.com.caelum.fj91.rh.persistencia.converters;

import org.springframework.stereotype.Service;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.persistencia.entities.FuncionarioEntity;
import br.com.caelum.fj91.rh.persistencia.entities.ReajusteEntity;

@Service
public class ReajusteEntityConverter {
	
	private final FuncionarioEntityConverter funcionarioConverter;
	
	public ReajusteEntityConverter(FuncionarioEntityConverter funcionarioConverter) {
		this.funcionarioConverter = funcionarioConverter;
	}

	public Reajuste convertToReajuste(ReajusteEntity entity) {
		Funcionario funcionario = funcionarioConverter.convertToFuncionario(entity.getFuncionario());
		return new Reajuste(entity.getId(), entity.getValor(), entity.getMotivo(), entity.getData(), funcionario);
	}
	
	public ReajusteEntity convertToReajusteEntity(Reajuste reajuste) {
		FuncionarioEntity funcionarioEntity = funcionarioConverter.convertToFuncionarioEntity(reajuste.getFuncionario());
		return new ReajusteEntity(reajuste.getId(), reajuste.getValor(), reajuste.getMotivo(), reajuste.getData(), funcionarioEntity);
	}

}
