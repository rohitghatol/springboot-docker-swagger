/**
 * 
 */
package com.synerzip.template.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.template.springboot.domain.Customer;
import com.synerzip.template.springboot.services.CustomerService;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author rohitghatol
 *
 */
@RestController
@RequestMapping("/apis/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Create Customer", response = Customer.class, httpMethod = "POST")
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@ApiOperation(value = "List Customers", response = Customer.class, responseContainer = "List", httpMethod = "GET")
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public Iterable<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
}
