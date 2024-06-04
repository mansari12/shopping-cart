/**
 * 
 */
package com.ecommerce.shoppingcart.service;

import java.util.List;

import com.ecommerce.shoppingcart.payload.request.CartRequest;
import com.ecommerce.shoppingcart.payload.response.CartResponse;

/**
 * 
 */
public interface CartService {
	
	CartResponse createCart(CartRequest cartRequest);
	CartResponse updateCart(long cartId, CartRequest cartRequest);
	CartResponse getCartById(long cartId);
	List<CartResponse> getAllCarts();
	void deleteCart(long cartId);
	
}
