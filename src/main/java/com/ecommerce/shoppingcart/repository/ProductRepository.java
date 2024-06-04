/**
 * 
 */
package com.ecommerce.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingcart.model.Product;

/**
 * 
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
