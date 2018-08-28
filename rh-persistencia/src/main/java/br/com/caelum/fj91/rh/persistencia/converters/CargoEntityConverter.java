package br.com.caelum.fj91.rh.persistencia.converters;

import org.springframework.stereotype.Service;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.persistencia.entities.CargoEntity;

@Service
public class CargoEntityConverter {
	
	public Cargo convertToCargo(CargoEntity entity) {
		return new Cargo(entity.getId(), entity.getNome(), entity.getSalarioMinimo(), entity.getSalarioMaximo());
	}
	
	public CargoEntity convertToCargoEntity(Cargo cargo) {
		return new CargoEntity(cargo.getId(), cargo.getNome(), cargo.getSalarioMinimo(), cargo.getSalarioMaximo());
	}

}
