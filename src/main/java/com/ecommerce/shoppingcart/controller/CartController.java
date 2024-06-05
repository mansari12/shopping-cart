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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppingcart.payload.request.CartRequest;
import com.ecommerce.shoppingcart.payload.response.CartResponse;
import com.ecommerce.shoppingcart.service.CartService;

/**
 * 
 */
@RestController
@RequestMapping("/v1/carts")
public class CartController {
	
	@Autowired 
	private CartService cartService;
	
	@PostMapping("/createCart")
	public CartResponse createCart(@RequestBody CartRequest cartRequest) {
		return cartService.createCart(cartRequest);
//		return cartService.createCart(cartRequest, null, null);
		
	}
	
	@PutMapping("/{cartId}")
	public CartResponse updateCart(@RequestParam long id, @RequestBody CartRequest cartRequest) {
		return cartService.updateCart(id, cartRequest);
//		return cartService.updateCart(id, cartRequest, null, null);
		
	}
	
	@GetMapping("/allCarts")
	public List<CartResponse> getAllCarts(){
		return cartService.getAllCarts();
	}
	
	@DeleteMapping("/{cartId}")
	public void deleteCart(@RequestParam long id) {
		cartService.deleteCart(id);
	}
	
	@GetMapping("/{cartId}")
	public CartResponse getCartById(@RequestParam long id) {
		return cartService.getCartById(id);
	}

}
