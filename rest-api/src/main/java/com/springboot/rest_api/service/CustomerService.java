package com.springboot.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.rest_api.exception.InvalidContactException;
import com.springboot.rest_api.exception.InvalidIDException;
import com.springboot.rest_api.model.Customer;
import com.springboot.rest_api.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	public List<Customer> getAllCustomer(Pageable pageable) 
	{
		return customerRepository.findAll(pageable).getContent()//without the stream it will show all the details
				.parallelStream()//with stream usage it filter the active ones only
				.filter(c->c.isActive() == true)
				//.sorted((a,b)->b.getId() - a.getId())
				.toList();
	}
	public Customer getSingleCustomer(int id) throws InvalidIDException {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("Entered ID is invalid.....");
		}
		
		return optional.get();
	}
	public void hardDelete(Customer customer) {
		customerRepository.delete(customer);
		
	}
	public void softDelete(Customer customer) {
		customer.setActive(false);
		customerRepository.save(customer);
		
	}
	public List<Customer> getAllCustomersByContact(String contact) {
		if(contact.length() != 8)//this must be ten but i have given the digits as mixed in db
			throw new InvalidContactException("Contact number invalid and must be 10 digits!!!");
		return customerRepository.findByContact(contact);
	}
	public List<Customer> getByIsActive(boolean status) {
		return customerRepository.findByIsActive(status);
	}

}
