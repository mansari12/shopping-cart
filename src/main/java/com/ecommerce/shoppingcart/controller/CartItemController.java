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

import com.ecommerce.shoppingcart.payload.request.CartItemRequest;
import com.ecommerce.shoppingcart.payload.response.CartItemResponse;
import com.ecommerce.shoppingcart.payload.response.RoleResponse;
import com.ecommerce.shoppingcart.service.CartItemService;

/**
 * 
 */
@RestController
@RequestMapping("/v1/cartItems")
public class CartItemController {
	
	@Autowired 
	private CartItemService cartItemService;
	
	@PostMapping("/addCartItem")
	public CartItemResponse addCartItem(@RequestBody CartItemRequest cartItemRequest) {
		return cartItemService.addCartItem(cartItemRequest);
		
	}
	
	@PutMapping("/{cartItemId}")
	public CartItemResponse updateCartItem(@PathVariable long id, @RequestBody CartItemRequest cartItemRequest) {
		return cartItemService.updateCartItem(id, cartItemRequest);
		
	}
	
	@GetMapping("/allCartItems")
	public List<CartItemResponse> getAllCartItems(){
		return cartItemService.getAllCartItems();
	}
	
	@DeleteMapping("/{cartItemId}")
	public void deleteCartItem(@PathVariable long id) {
		cartItemService.deleteCartItem(id);
	}
	
	@GetMapping("/{cartItemId}")
	public CartItemResponse getCartItemById(@PathVariable long id) {
		return cartItemService.getCartItemById(id);
	}

}
