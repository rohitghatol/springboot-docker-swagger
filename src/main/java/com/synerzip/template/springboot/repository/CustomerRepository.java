/**
 * 
 */
package com.synerzip.template.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.synerzip.template.springboot.domain.Customer;


/**
 * @author rohitghatol
 *
 */


public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}