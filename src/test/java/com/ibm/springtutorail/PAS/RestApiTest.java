package com.ibm.springtutorail.PAS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.spring.PAS.PasApplication;
import com.ibm.spring.PAS.entity.Employee;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
		classes = PasApplication.class)
class RestApiTest {

	@Autowired
	private TestRestTemplate restTemplate;

	/*在Spring Boot Test測試程式可使用@LocalServerPort取得測試的web應用程式的port號
	相當於@Value("${local.server.port}")
	需注意若mock web環境無法正確注入*/
	@LocalServerPort
	int randomServerPort;
	
	@Test
	public void testRestEmpFindById() throws URISyntaxException {
	    // target location
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/employee/2";
		
	    URI uri = new URI(baseUrl);

	    // restTemplate focus on getForEntity 、 postForEntity 、 exchange
		ResponseEntity<Employee> responseEntity = this.restTemplate.getForEntity(uri,Employee.class);

		Employee employee = responseEntity.getBody();
		System.out.println("employee = " + employee);

		// Verify request succeed
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());		
	}
	
	
}
