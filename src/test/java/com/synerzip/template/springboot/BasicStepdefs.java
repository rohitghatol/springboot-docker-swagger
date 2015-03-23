package com.synerzip.template.springboot;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.synerzip.template.springboot.domain.Customer;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicStepdefs {
	final String BASE_URL = "http://localhost:8080/apis/customers";

	private RestTemplate rest = new RestTemplate();

	@Before
	public void setup() throws IOException {

	}

	@After
	public void destroy() {

	}

	@When("^I store a new Customer\\[firstname=\"(.*?)\",lastname=\"(.*?)\"$")
	public void storeCustomer(String firstName,String lastName) throws Throwable {
		System.out.println("When I store a Customer[firstName=\""+firstName+"\",lastName=\""+lastName+"\"]");
		
		Customer customer = new Customer(firstName, lastName);
		ResponseEntity<Customer> response = rest.postForEntity(BASE_URL,customer, Customer.class);
		Customer returnedCustomer = response.getBody();
		assertEquals(customer.getFirstName(), returnedCustomer.getFirstName());
		assertEquals(customer.getLastName(), returnedCustomer.getLastName());

		

	}

	

	@Then("^I expect to see Customer\\[firstname=\"(.*?)\",lastname=\"(.*?)\" in List of Customers$")
	public void i_expect_to_see(String firstName,String lastName) throws Throwable {
		System.out.println("I expect to see Customer[firstname=\""+firstName+"\",lastname=\""+lastName+"\" in List of Customers");
		
		ResponseEntity<Customer[]> response = rest.getForEntity(BASE_URL,
				Customer[].class);

		Customer customer = new Customer(firstName, lastName);
		Customer[] customers = response.getBody();
		
		boolean matchfound=false;
		for(Customer entity:customers){
			if(entity.getFirstName().equals(customer.getFirstName()) && entity.getLastName().equals(customer.getLastName())){
				matchfound = true;
			}
		}
		
		assertTrue("Did not find Customer in return list",matchfound);
	}
}
