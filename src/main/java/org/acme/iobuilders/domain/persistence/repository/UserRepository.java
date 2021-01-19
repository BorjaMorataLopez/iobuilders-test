package org.acme.iobuilders.domain.persistence.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.iobuilders.domain.persistence.entitites.UserEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

	public UserEntity findById(String id) {
		return (UserEntity) find("id", id).firstResult();
	}
}
