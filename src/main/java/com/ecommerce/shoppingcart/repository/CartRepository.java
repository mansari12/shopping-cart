/**
 * 
 */
package com.ecommerce.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shoppingcart.model.Cart;

/**
 * 
 */
public interface CartRepository extends JpaRepository<Cart, Long> {

}
