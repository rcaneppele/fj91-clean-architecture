package br.com.caelum.fj91.rh.persistencia.converters;

import org.springframework.stereotype.Service;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.persistencia.entities.CargoEntity;
import br.com.caelum.fj91.rh.persistencia.entities.FuncionarioEntity;

@Service
public class FuncionarioEntityConverter {
	
	private final CargoEntityConverter cargoConverter;
	
	public FuncionarioEntityConverter(CargoEntityConverter cargoConverter) {
		this.cargoConverter = cargoConverter;
	}

	public Funcionario convertToFuncionario(FuncionarioEntity entity) {
		Cargo cargo = cargoConverter.convertToCargo(entity.getCargo());
		return new Funcionario(entity.getId(), entity.getNome(), entity.getSalario(), cargo, entity.getDataDeAdmissao());
	}
	
	public FuncionarioEntity convertToFuncionarioEntity(Funcionario funcionario) {
		CargoEntity cargoEntity = cargoConverter.convertToCargoEntity(funcionario.getCargo());
		return new FuncionarioEntity(funcionario.getId(), funcionario.getNome(), funcionario.getSalario(), cargoEntity, funcionario.getDataDeAdmissao());
	}

}
