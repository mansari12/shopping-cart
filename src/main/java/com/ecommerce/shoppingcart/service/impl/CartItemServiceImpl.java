/**
 * 
 */
package com.ecommerce.shoppingcart.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingcart.model.CartItem;
import com.ecommerce.shoppingcart.model.Product;
import com.ecommerce.shoppingcart.payload.request.CartItemRequest;
import com.ecommerce.shoppingcart.payload.response.CartItemResponse;
import com.ecommerce.shoppingcart.repository.CartItemRepository;
import com.ecommerce.shoppingcart.repository.ProductRepository;
import com.ecommerce.shoppingcart.service.CartItemService;
import com.ecommerce.shoppingcart.service.exception.CustomException;

/**
 * 
 */

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public CartItemResponse addCartItem(CartItemRequest cartItemRequest) {
		Product product = productRepository.findById(cartItemRequest.getProductId())
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(cartItemRequest.getQuantity());
		cartItem.setCartItemsTotalPrice(cartItemRequest.getCartItemsTotalPrice());
		cartItem.setCreatedBy(cartItemRequest.getCreatedBy());
		cartItem.setCreatedDate(LocalDateTime.now());
		cartItem.setUpdatedBy(cartItemRequest.getUpdatedBy());
		cartItem.setUpdatedDate(LocalDateTime.now());
		
		cartItemRepository.save(cartItem);
		
		return mapToResponse(cartItem);
		
	}

	@Override
	public CartItemResponse updateCartItem(long cartItemId, CartItemRequest cartItemRequest) {
		CartItem updatedCartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		Product product = productRepository.findById(cartItemRequest.getProductId())
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		updatedCartItem.setProduct(product);
		updatedCartItem.setQuantity(cartItemRequest.getQuantity());
		updatedCartItem.setCartItemsTotalPrice(cartItemRequest.getCartItemsTotalPrice());
		updatedCartItem.setUpdatedBy(cartItemRequest.getUpdatedBy());
		updatedCartItem.setUpdatedDate(LocalDateTime.now());
		
		cartItemRepository.save(updatedCartItem);
		
		return mapToResponse(updatedCartItem);
		
	}

	@Override
	public CartItemResponse getCartItemById(long cartItemId) {
		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		return mapToResponse(cartItem);
	}

	@Override
	public List<CartItemResponse> getAllCartItems() {
		List<CartItem> cartItems = cartItemRepository.findAll();
		
		return cartItems.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public void deleteCartItem(long cartItemId) {
		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		cartItemRepository.delete(cartItem);
	}
	
	
	private CartItemResponse mapToResponse(CartItem cartItem) {
		CartItemResponse cartItemResponse = new CartItemResponse();
		cartItemResponse.setCartItemId(cartItem.getCartItemId());
		cartItemResponse.setCartId(cartItem.getCart().getCartId());
		cartItemResponse.setProductId(cartItem.getProduct().getProductId());
		cartItemResponse.setQuantity(cartItem.getQuantity());
		cartItemResponse.setCartItemsTotalPrice(cartItem.getCartItemsTotalPrice());
		cartItemResponse.setCreatedBy(cartItem.getCreatedBy());
		cartItemResponse.setCreatedDate(cartItem.getCreatedDate());
		cartItemResponse.setUpdatedBy(cartItem.getUpdatedBy());
		cartItemResponse.setUpdatedDate(cartItem.getUpdatedDate());
		
		return cartItemResponse;
	
		
	}
	
	

}
