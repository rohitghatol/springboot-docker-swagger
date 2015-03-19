/**
 * 
 */
package com.synerzip.template.springboot.services;

import com.synerzip.template.springboot.domain.Customer;

/**
 * @author rohitghatol
 *
 */
public interface CustomerService {

	public Iterable<Customer> getAllCustomers();
	
	public Customer createCustomer(Customer customer);
}
