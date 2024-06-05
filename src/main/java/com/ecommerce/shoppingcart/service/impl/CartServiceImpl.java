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
import com.ecommerce.shoppingcart.repository.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public CartResponse createCart(CartRequest cartRequest) {
//		CartResponse createCart(CartRequest cartRequest, ProductRequest productRequest, CartItemRequest cartItemRequest)
		Customer customer = customerRepository.findById(cartRequest.getCustomerId())
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
//		cart.setCustomer();
//		double subTotal = getSubTotal(productRequest, cartItemRequest);
//		cart.setSubTotal(subTotal);
		
		cart.setSubTotal(cartRequest.getSubTotal());
		cart.setShippingFee(cartRequest.getShippingFee());
//		cart.setTotalPrice(cartRequest.getTotalPrice());
		cart.setDiscountAmount(cartRequest.getDiscountAmount());
		
//		double taxAmount = getTaxAmount(productRequest);
//		cart.setTaxAmount(taxAmount);
		
//		double totalPrice = getTotalPrice(cartRequest);
//		cart.setTotalPrice(totalPrice);
		
//		cart.setTotalPrice(cartRequest.getTotalPrice());
		cart.setStatus(cartRequest.getStatus());
//		cart.setCreatedBy(cartRequest.getCreatedBy());
		cart.setCreatedDate(LocalDateTime.now());
//		cart.setUpdatedBy(cartRequest.getUpdatedBy());
		cart.setUpdatedDate(LocalDateTime.now());
		
		cartRepository.save(cart);
		
		return mapToResponse(cart);
		
	}

	

	@Override
	public CartResponse updateCart(long cartId, CartRequest cartRequest) {
//	public CartResponse updateCart(long cartId, CartRequest cartRequest, ProductRequest productRequest, CartItemRequest cartItemRequest) {
		Cart updatedcart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		Customer customer = customerRepository.findById(cartRequest.getCustomerId())
				.orElseThrow(() -> new CustomException("Customer not found"));
		
		updatedcart.setCustomer(customer);
		
//		double subTotal = getSubTotal(productRequest, cartItemRequest);
//		updatedcart.setSubTotal(subTotal);

		updatedcart.setSubTotal(cartRequest.getSubTotal());
		updatedcart.setShippingFee(cartRequest.getShippingFee());
//		updatedcart.setTotalPrice(cartRequest.getTotalPrice());
		updatedcart.setDiscountAmount(cartRequest.getDiscountAmount());
		
//		double taxAmount = getTaxAmount(productRequest);
//		updatedcart.setTaxAmount(taxAmount);
		
//		double totalPrice = getTotalPrice(cartRequest);
//		updatedcart.setTotalPrice(totalPrice);
		
		updatedcart.setTaxAmount(cartRequest.getTaxAmount());
//		updatedcart.setTotalPrice(cartRequest.getTotalPrice());
		updatedcart.setStatus(cartRequest.getStatus());
//		updatedcart.setUpdatedBy(cartRequest.getUpdatedBy());
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
	
	
	
//	private double getTaxAmount(ProductRequest productRequest) {
//		return productRequest.getProductPrice() * productRequest.getTaxRate() / 100;
//	}
//	
//	private double getSubTotal(ProductRequest productRequest, CartItemRequest cartItemRequest) {
//		return productRequest.getProductPrice() * cartItemRequest.getQuantity();
//
//	}
//	
//	private double getTotalPrice(CartRequest cartRequest) {
//		
//		return (cartRequest.getSubTotal() - cartRequest.getDiscountAmount()) + cartRequest.getTaxAmount() + cartRequest.getShippingFee();
//	}
	
	
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



	@Override
	public void saveCart(long cartId) {
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		cart.setStatus(Cart.Status.SAVED);
		cartRepository.save(cart);
		
	}



//	@Override
//	public List<CartResponse> getSavedCartsByCustomerId(long customerId) {
//		List<Cart> savedCarts = cartRepository.findByCustomerIdAndStatus(customerId, Cart.Status.SAVED);
//		return savedCarts.stream()
//				.map(this::mapToResponse)
//				.collect(Collectors.toList());
//		
//	}

}
