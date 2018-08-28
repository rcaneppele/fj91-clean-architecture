package br.com.caelum.fj91.rh.persistencia.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.caelum.fj91.rh.domain.funcionario.Funcionario;
import br.com.caelum.fj91.rh.domain.reajuste.Reajuste;
import br.com.caelum.fj91.rh.domain.reajuste.ReajusteRepository;
import br.com.caelum.fj91.rh.persistencia.converters.FuncionarioEntityConverter;
import br.com.caelum.fj91.rh.persistencia.converters.ReajusteEntityConverter;
import br.com.caelum.fj91.rh.persistencia.entities.ReajusteEntity;

@Repository
public class JpaReajusteRepository implements ReajusteRepository {
	
	private final EntityManager manager;
	private final ReajusteEntityConverter reajusteConverter;
	private FuncionarioEntityConverter funcionarioConverter; 
	
	public JpaReajusteRepository(EntityManager manager, ReajusteEntityConverter reajusteConverter, FuncionarioEntityConverter funcionarioConverter) {
		this.manager = manager;
		this.reajusteConverter = reajusteConverter;
		this.funcionarioConverter = funcionarioConverter;
	}

	@Transactional
	public void salvar(Reajuste reajuste) {
		ReajusteEntity entity = reajusteConverter.convertToReajusteEntity(reajuste);
		manager.persist(entity);
	}

	@Override
	public Reajuste ultimoReajusteDoFuncionario(Funcionario funcionario) {
		List<ReajusteEntity> reajustes = 
				manager.createQuery("SELECT r FROM Reajuste r WHERE r.funcionario = :funcionario ORDER BY r.id DESC", ReajusteEntity.class)
				.setParameter("funcionario", funcionarioConverter.convertToFuncionarioEntity(funcionario))
				.setMaxResults(1)
				.getResultList();
		
		if (reajustes.isEmpty()) {
			return null;
		}
		
		return reajusteConverter.convertToReajuste(reajustes.get(0));
	}
	
	@Override
	public List<Reajuste> carregarReajustesDoFuncionario(Funcionario funcionario) {
		return manager.createQuery("SELECT r FROM Reajuste r WHERE r.funcionario = :funcionario ORDER BY r.id DESC", ReajusteEntity.class)
				.setParameter("funcionario", funcionarioConverter.convertToFuncionarioEntity(funcionario))
				.getResultList()
				.stream()
				.map(entity -> reajusteConverter.convertToReajuste(entity))
				.collect(Collectors.toList());
	}

}
