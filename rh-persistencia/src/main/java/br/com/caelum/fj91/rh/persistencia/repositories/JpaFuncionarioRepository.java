package br.com.caelum.fj91.rh.persistencia.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.rh.domain.cargo.Cargo;
import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.funcionario.FuncionarioRepository;
import br.com.caelum.fj91.rh.persistencia.converters.CargoEntityConverter;
import br.com.caelum.fj91.rh.persistencia.converters.FuncionarioEntityConverter;
import br.com.caelum.fj91.rh.persistencia.entities.FuncionarioEntity;

@Repository
public class JpaFuncionarioRepository implements FuncionarioRepository {
	
	private final EntityManager manager;
	private final FuncionarioEntityConverter funcionarioConverter;
	private final CargoEntityConverter cargoConverter;
	
	public JpaFuncionarioRepository(EntityManager manager, FuncionarioEntityConverter funcionarioConverter, CargoEntityConverter cargoConverter) {
		this.manager = manager;
		this.funcionarioConverter = funcionarioConverter;
		this.cargoConverter = cargoConverter;
	}

	@Transactional
	public void salvar(Funcionario funcionario) {
		FuncionarioEntity entity = funcionarioConverter.convertToFuncionarioEntity(funcionario);
		manager.persist(entity);
	}

	@Transactional
	public void excluir(Funcionario funcionario) {
		FuncionarioEntity entity = manager.getReference(FuncionarioEntity.class, funcionario.getId());
		manager.remove(entity);
	}

	public List<Funcionario> carregarTodos() {
		return manager
				.createQuery("SELECT f FROM Funcionario f", FuncionarioEntity.class)
				.getResultList()
				.stream()
				.map(entity -> funcionarioConverter.convertToFuncionario(entity))
				.collect(Collectors.toList());
	}

	public boolean existeAlgumComCargo(Cargo cargo) {
		Long count = manager.createQuery("SELECT count(f.id) FROM Funcionario f WHERE f.cargo = :cargo", Long.class)
			.setParameter("cargo", cargoConverter.convertToCargoEntity(cargo))
			.getSingleResult();
		return count > 0;
	}
	
	@Override
	public Funcionario buscarPorId(Long id) {
		FuncionarioEntity entity = manager.find(FuncionarioEntity.class, id);
		return funcionarioConverter.convertToFuncionario(entity);
	}

}
