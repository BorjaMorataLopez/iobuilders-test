package org.acme.iobuilders.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.acme.iobuilders.application.api.dto.UserDto;
import org.acme.iobuilders.infraestructure.api.BankApi;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BankApiTest {
	
	@Inject
	BankApi api;

//    @Test
//    public void testHelloEndpoint() {
//        given()
//          .when().get("/hello")
//          .then()
//             .statusCode(200)
//             .body(is("Hello RESTEasy"));
//    }
	
	@Test
	public void getUserTest() {
		Response res = api.getUser("IDTEST");
		assertNotNull(res);
		assertTrue(res.getStatus() == 200);
		UserDto user = (UserDto) res.getEntity();
		assertNotNull(user);
		assertEquals("IDTEST", user.getId());
	}
	
	@Test
	public void createUser() {
		UserDto user = new UserDto();
		user.setId("TEST");
		user.setName("TESTNAME");
		user.setSurname("TESTSURNAME");
		user.setMoney(100);
		user.setAge(30);
		
		Response res = api.createUser(user);
		assertNotNull(res);
		assertTrue(res.getStatus() == 200);
	}
	
	@Test
	public void addMoney() {
		Response res = api.addMoney("IDTEST", 50);
		assertNotNull(res);
		assertTrue(res.getStatus() == 200);
	}
	
	@Test
	public void transfer() {
		Response res = api.transfer("IDTEST", "IDTEST2", 10);
		assertNotNull(res);
		assertTrue(res.getStatus() == 200);
	}

}