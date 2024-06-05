/**
 * 
 */
package com.ecommerce.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppingcart.payload.request.CustomerRequest;
import com.ecommerce.shoppingcart.payload.response.CustomerResponse;
import com.ecommerce.shoppingcart.service.CustomerService;

/**
 * 
 */
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.addCustomer(customerRequest);
		
	}
	
	@PutMapping("/{customerId}")
	public CustomerResponse updateCustomer(@PathVariable long id, @RequestBody CustomerRequest customerRequest) {
		return customerService.updateCustomer(id, customerRequest);
		
	}
	
	@GetMapping("/allCustomers")
	public List<CustomerResponse> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
	}
	
	@GetMapping("/{customerId}")
	public CustomerResponse getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
}
