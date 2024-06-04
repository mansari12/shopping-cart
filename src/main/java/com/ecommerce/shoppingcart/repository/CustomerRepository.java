/**
 * 
 */
package com.ecommerce.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingcart.model.Customer;

/**
 * 
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
