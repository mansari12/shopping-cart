/**
 * 
 */
package com.ecommerce.shoppingcart.service;

import java.util.List;

import com.ecommerce.shoppingcart.payload.request.CustomerRequest;
import com.ecommerce.shoppingcart.payload.response.CustomerResponse;

/**
 * 
 */
public interface CustomerService {
	CustomerResponse addCustomer(CustomerRequest customerRequest);
	CustomerResponse updateCustomer(long customerId, CustomerRequest customerRequest);
	CustomerResponse getCustomerById(long customerId);
	List<CustomerResponse> getAllCustomers();
	void deleteCustomer(long customerId);
	

}
