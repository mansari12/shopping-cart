/**
 * 
 */
package com.ecommerce.shoppingcart.service;

import java.util.List;

import com.ecommerce.shoppingcart.payload.request.CartItemRequest;
import com.ecommerce.shoppingcart.payload.response.CartItemResponse;

/**
 * 
 */
public interface CartItemService {
	
	CartItemResponse addCartItem(CartItemRequest cartItemRequest);
	CartItemResponse updateCartItem(long cartItemId, CartItemRequest cartItemRequest);
	CartItemResponse getCartItemById(long cartItemId);
	List<CartItemResponse> getAllCartItems();
	void deleteCartItem(long cartItemId);
	

}
