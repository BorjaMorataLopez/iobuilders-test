package org.acme.iobuilders.application.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.acme.iobuilders.domain.persistence.PersistenceService;
import org.acme.iobuilders.domain.persistence.entitites.UserEntity;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PersistenceServiceRepositoryTest {
	
	@Inject
	PersistenceService persistenceService;

	@Test
	public void getUserTest() {
		UserEntity user = persistenceService.getUser("IDTEST");
		assertNotNull(user);
		assertEquals("IDTEST", user.getId());
		assertEquals("Paco", user.getName());
		assertEquals("Perez", user.getSurname());
		assertTrue(user.getAge() == 40);
		assertTrue(user.getMoney() == 30000);
	}
	
	@Test
	public void createUser() {
		UserEntity user = new UserEntity();
		user.setId("TESTENTITY");
		user.setName("TESTNAME");
		user.setSurname("TESTSURNAME");
		user.setMoney(100);
		user.setAge(30);
		
		persistenceService.createUser(user);
		
		assertNotNull(persistenceService.getUser("TESTENTITY"));
	}
	
	@Test
	public void addMoney() {
		persistenceService.addMoney("IDTEST6", 50);

		assertTrue(persistenceService.getUser("IDTEST6").getMoney() == 8050);
	}
	
	@Test
	public void transfer() {
		persistenceService.transfer("IDTEST7", "IDTEST8", 10);
		
		assertTrue(persistenceService.getUser("IDTEST7").getMoney() == 15990);
		assertTrue(persistenceService.getUser("IDTEST8").getMoney() == 4010);
	}

}