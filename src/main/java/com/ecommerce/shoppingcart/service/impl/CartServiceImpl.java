/**
 * 
 */
package com.ecommerce.shoppingcart.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingcart.model.Cart;
import com.ecommerce.shoppingcart.model.Customer;
import com.ecommerce.shoppingcart.payload.request.CartRequest;
import com.ecommerce.shoppingcart.payload.response.CartResponse;
import com.ecommerce.shoppingcart.repository.CartRepository;
import com.ecommerce.shoppingcart.repository.CustomerRepository;
import com.ecommerce.shoppingcart.service.CartService;
import com.ecommerce.shoppingcart.service.exception.CustomException;

/**
 * 
 */
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CartResponse createCart(CartRequest cartRequest) {
		
		Customer customer = customerRepository.findById(cartRequest.getCustomerId())
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setSubTotal(cartRequest.getSubTotal());
		cart.setShippingFee(cartRequest.getShippingFee());
		cart.setTotalPrice(cartRequest.getTotalPrice());
		cart.setDiscountAmount(cartRequest.getDiscountAmount());
		cart.setTotalPrice(cartRequest.getTotalPrice());
		cart.setStatus(cartRequest.getStatus());
		cart.setCreatedBy(cartRequest.getCreatedBy());
		cart.setCreatedDate(LocalDateTime.now());
		cart.setUpdatedBy(cartRequest.getUpdatedBy());
		cart.setUpdatedDate(LocalDateTime.now());
		
		cartRepository.save(cart);
		
		return mapToResponse(cart);
		
	}

	@Override
	public CartResponse updateCart(long cartId, CartRequest cartRequest) {
		Cart updatedcart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		Customer customer = customerRepository.findById(cartRequest.getCustomerId())
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		updatedcart.setCustomer(customer);
		updatedcart.setSubTotal(cartRequest.getSubTotal());
		updatedcart.setShippingFee(cartRequest.getShippingFee());
		updatedcart.setTotalPrice(cartRequest.getTotalPrice());
		updatedcart.setDiscountAmount(cartRequest.getDiscountAmount());
		updatedcart.setTotalPrice(cartRequest.getTotalPrice());
		updatedcart.setStatus(cartRequest.getStatus());
		updatedcart.setUpdatedBy(cartRequest.getUpdatedBy());
		updatedcart.setUpdatedDate(LocalDateTime.now());
		
		cartRepository.save(updatedcart);
		
		return mapToResponse(updatedcart);
	}

	@Override
	public CartResponse getCartById(long cartId) {
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		return mapToResponse(cart);
	}

	@Override
	public List<CartResponse> getAllCarts() {
		List<Cart> carts = cartRepository.findAll();
		
		return carts.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public void deleteCart(long cartId) {
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		cartRepository.delete(cart);
	}
	
	
	
	private CartResponse mapToResponse(Cart cart) {
		CartResponse cartResponse = new CartResponse();
		cartResponse.setCartId(cart.getCartId());
		cartResponse.setCustomerId(cart.getCustomer().getCustomerId());
		cartResponse.setSubTotal(cart.getSubTotal());
		cartResponse.setDiscountAmount(cart.getDiscountAmount());
		cartResponse.setTaxAmount(cart.getTaxAmount());
		cartResponse.setShippingFee(cart.getShippingFee());
		cartResponse.setTotalPrice(cart.getTotalPrice());
		cartResponse.setStatus(cart.getUpdatedBy());
		cartResponse.setCreatedBy(cart.getCreatedBy());
		cartResponse.setCreatedDate(cart.getCreatedDate());
		cartResponse.setUpdatedBy(cart.getUpdatedBy());
		cartResponse.setUpdatedDate(cart.getUpdatedDate());
		
		return cartResponse;
	
		
	}

}
