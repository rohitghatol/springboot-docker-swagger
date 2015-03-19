/**
 * 
 */
package com.synerzip.template.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.synerzip.template.springboot.domain.Customer;
import com.synerzip.template.springboot.repository.CustomerRepository;

/**
 * @author rohitghatol
 *
 */
@Component("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository = null;
	
	/* (non-Javadoc)
	 * @see com.synerzip.template.springboot.services.CustomerService#getAllCustomers()
	 */
	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
