package br.com.caelum.fj91.rh.persistencia.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.cargo.CargoRepository;
import br.com.caelum.fj91.rh.persistencia.converters.CargoEntityConverter;
import br.com.caelum.fj91.rh.persistencia.entities.CargoEntity;

@Repository
public class JpaCargoRepository implements CargoRepository {
	
	private final EntityManager manager;
	private final CargoEntityConverter converter; 
	
	public JpaCargoRepository(EntityManager manager, CargoEntityConverter converter) {
		this.manager = manager;
		this.converter = converter;
	}

	@Transactional
	public void salvar(Cargo cargo) {
		CargoEntity entity = converter.convertToCargoEntity(cargo);
		manager.persist(entity);
	}

	public boolean jaEstaCadastrado(String nome) {
		try {
			manager.createQuery("SELECT c.id FROM Cargo c WHERE c.nome = :nome", Long.class)
				.setParameter("nome", nome)
				.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Transactional
	public void excluir(Cargo cargo) {
		CargoEntity entity = manager.getReference(CargoEntity.class, cargo.getId());
		manager.remove(entity);
	}

	public List<Cargo> carregarTodos() {
		return manager
				.createQuery("SELECT c FROM Cargo c", CargoEntity.class)
				.getResultList()
				.stream()
				.map(entity -> converter.convertToCargo(entity))
				.collect(Collectors.toList());
	}

	public Cargo buscarPorId(Long id) {
		CargoEntity entity = manager.find(CargoEntity.class, id);
		return converter.convertToCargo(entity);
	}

}
