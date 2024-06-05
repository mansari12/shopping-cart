/**
 * 
 */
package com.ecommerce.shoppingcart.service;

import java.util.List;

import com.ecommerce.shoppingcart.payload.request.CartItemRequest;
import com.ecommerce.shoppingcart.payload.request.CartRequest;
import com.ecommerce.shoppingcart.payload.request.ProductRequest;
import com.ecommerce.shoppingcart.payload.response.CartResponse;

/**
 * 
 */
public interface CartService {
	
	CartResponse createCart(CartRequest cartRequest);
	
//	CartResponse createCart(CartRequest cartRequest, ProductRequest productRequest, CartItemRequest cartItemRequest);
//	CartResponse updateCart(long cartId, CartRequest cartRequest, ProductRequest productRequest, CartItemRequest cartItemRequest);
	
	CartResponse updateCart(long cartId, CartRequest cartRequest);

	CartResponse getCartById(long cartId);
	List<CartResponse> getAllCarts();
	void deleteCart(long cartId);
	void saveCart(long cartId);
//	List<CartResponse> getSavedCartsByCustomerId(long customerId);
	
}
