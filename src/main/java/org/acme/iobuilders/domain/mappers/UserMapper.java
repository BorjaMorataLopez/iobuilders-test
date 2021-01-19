package org.acme.iobuilders.domain.mappers;

import org.acme.iobuilders.application.api.dto.UserDto;
import org.acme.iobuilders.domain.persistence.entitites.UserEntity;

public class UserMapper {
	
	public static UserEntity dtoToEntity(UserDto dto) {
		UserEntity entity = new UserEntity();
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setAge(dto.getAge());
		entity.setMoney(dto.getMoney());
		
		return entity;
	}
	
	public static UserDto entityToDto(UserEntity entity) {
		UserDto dto = new UserDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setAge(entity.getAge());
		dto.setMoney(entity.getMoney());
		
		return dto;
	}

}
