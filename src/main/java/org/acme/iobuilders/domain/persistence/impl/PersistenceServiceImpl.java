package org.acme.iobuilders.domain.persistence.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.iobuilders.domain.persistence.PersistenceService;
import org.acme.iobuilders.domain.persistence.entitites.UserEntity;
import org.acme.iobuilders.domain.persistence.repository.UserRepository;

@ApplicationScoped
public class PersistenceServiceImpl implements PersistenceService {
	
	@Inject
	UserRepository repository;

	@Override
	@Transactional
	public void createUser(UserEntity user) {
		repository.persist(user);
	}

	@Override
	@Transactional
	public void addMoney(String id, double amount) {
		UserEntity entity = repository.findById(id);
		if(entity != null) {
			entity.setMoney(entity.getMoney() + amount);
		}
	}

	@Override
	@Transactional
	public void transfer(String idOrigin, String idDestination, double amount) {
		UserEntity entityOrigin = repository.findById(idOrigin);
		UserEntity entityDestination = repository.findById(idDestination);
		if(entityOrigin != null && entityDestination != null) {
			entityOrigin.setMoney(entityOrigin.getMoney() - amount);
			entityDestination.setMoney(entityDestination.getMoney() + amount);
		}
	}

	@Override
	public UserEntity getUser(String id) {
		return repository.findById(id);
	}

}
