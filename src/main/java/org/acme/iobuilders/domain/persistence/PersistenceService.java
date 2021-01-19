package org.acme.iobuilders.domain.persistence;

import org.acme.iobuilders.domain.persistence.entitites.UserEntity;

public interface PersistenceService {
	
	public UserEntity getUser(String id);
	public void createUser(UserEntity user);
	public void addMoney(String id, double amount);
	public void transfer(String idOrigin, String idDestination, double amount);

}
