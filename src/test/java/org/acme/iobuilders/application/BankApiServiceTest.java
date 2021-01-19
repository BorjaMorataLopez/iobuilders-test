package org.acme.iobuilders.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.acme.iobuilders.application.api.dto.UserDto;
import org.acme.iobuilders.application.service.BankApiService;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BankApiServiceTest {
	
	@Inject
	BankApiService service;

	@Test
	public void getUserTest() {
		UserDto user = service.getUser("IDTEST");
		assertNotNull(user);
		assertEquals("IDTEST", user.getId());
		assertEquals("Paco", user.getName());
		assertEquals("Perez", user.getSurname());
		assertTrue(user.getAge() == 40);
		assertTrue(user.getMoney() == 30000);
	}
	
	@Test
	public void createUser() {
		UserDto user = new UserDto();
		user.setId("TEST");
		user.setName("TESTNAME");
		user.setSurname("TESTSURNAME");
		user.setMoney(100);
		user.setAge(30);
		
		service.createUser(user);
		
		assertNotNull(service.getUser("TEST"));
	}
	
	@Test
	public void addMoney() {
		service.addMoney("IDTEST3", 50);

		assertTrue(service.getUser("IDTEST3").getMoney() == 80);
	}
	
	@Test
	public void transfer() {
		service.transfer("IDTEST4", "IDTEST5", 10);
		
		assertTrue(service.getUser("IDTEST4").getMoney() == 990);
		assertTrue(service.getUser("IDTEST5").getMoney() == 8010);
	}

}