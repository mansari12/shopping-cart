/**
 * 
 */
package com.ecommerce.shoppingcart.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingcart.model.Customer;
import com.ecommerce.shoppingcart.payload.request.CustomerRequest;
import com.ecommerce.shoppingcart.payload.response.CustomerResponse;
import com.ecommerce.shoppingcart.repository.CustomerRepository;
import com.ecommerce.shoppingcart.service.CustomerService;
import com.ecommerce.shoppingcart.service.exception.CustomException;

/**
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerResponse addCustomer(CustomerRequest customerRequest) {
		
		Customer customer = new Customer();
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setEmail(customerRequest.getEmail());
		customer.setPassword(customerRequest.getPassword());
		customer.setCreatedBy("system");
		customer.setCreatedDate(LocalDateTime.now());
		customer.setUpdatedBy("system");
		customer.setUpdatedDate(LocalDateTime.now());
		customerRepository.save(customer);
		
		return mapToResponse(customer);
	}

	@Override
	public CustomerResponse updateCustomer(long customerId, CustomerRequest customerRequest) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomException ("customer not found"));
		
		
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setEmail(customerRequest.getEmail());
		customer.setPassword(customerRequest.getPassword());
		customer.setUpdatedBy("system");
		customer.setUpdatedDate(LocalDateTime.now());
		customerRepository.save(customer);
		
		return mapToResponse(customer);
	}

	@Override
	public CustomerResponse getCustomerById(long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		return mapToResponse(customer);
	}

	@Override
	public List<CustomerResponse> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		
		return customers.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public void deleteCustomer(long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		customerRepository.delete(customer);
	}
	
	
	private CustomerResponse mapToResponse(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setCustomerId(customer.getCustomerId());
		customerResponse.setCustomerName(customer.getCustomerName());
		customerResponse.setEmail(customer.getEmail());
		customerResponse.setCreatedBy(customer.getCreatedBy());
		customerResponse.setCreatedDate(customer.getCreatedDate());
		customerResponse.setUpdatedBy(customer.getUpdatedBy());
		customerResponse.setUpdatedDate(customer.getUpdatedDate());
		
		return customerResponse;
	
		
	}

}
