package org.acme.iobuilders.application.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.acme.iobuilders.application.api.dto.UserDto;
import org.acme.iobuilders.application.service.BankApiService;
import org.acme.iobuilders.domain.mappers.UserMapper;
import org.acme.iobuilders.domain.persistence.PersistenceService;

@RequestScoped
public class BankApiServiceImpl implements BankApiService {
	
	@Inject
	PersistenceService service;

	@Override
	public void createUser(UserDto user) {
		service.createUser(UserMapper.dtoToEntity(user));
	}

	@Override
	public void addMoney(String id, double amount) {
		service.addMoney(id, amount);
	}

	@Override
	public void transfer(String idOrigin, String idDestination, double amount) {
		service.transfer(idOrigin, idDestination, amount);
	}

	@Override
	public UserDto getUser(String id) {
		return UserMapper.entityToDto(service.getUser(id));
	}


}