package org.acme.iobuilders.application.service;

import org.acme.iobuilders.application.api.dto.UserDto;

public interface BankApiService {
	
	public UserDto getUser(String id);
	public void createUser(UserDto user);
	public void addMoney(String id, double amount);
	public void transfer(String idOrigin, String idDestination, double amount);

}
