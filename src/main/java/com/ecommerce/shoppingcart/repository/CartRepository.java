/**
 * 
 */
package com.ecommerce.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shoppingcart.model.Cart;

/**
 * 
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByCartId(long cartId);
	
//	List<Cart> findByCustomerIdAndStatus(Long customerId, Cart.Status status);

}
