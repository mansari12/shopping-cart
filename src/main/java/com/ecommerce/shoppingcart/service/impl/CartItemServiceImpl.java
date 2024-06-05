/**
 * 
 */
package com.ecommerce.shoppingcart.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingcart.model.Cart;
import com.ecommerce.shoppingcart.model.CartItem;
import com.ecommerce.shoppingcart.model.Product;
import com.ecommerce.shoppingcart.payload.request.CartItemRequest;
import com.ecommerce.shoppingcart.payload.response.CartItemResponse;
import com.ecommerce.shoppingcart.repository.CartItemRepository;
import com.ecommerce.shoppingcart.repository.CartRepository;
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
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@Override
	public CartItemResponse addCartItem(CartItemRequest cartItemRequest) {
	    // Get the product
	    List<Product> product = productRepository.findByProductId(cartItemRequest.getProductId());
//	    System.out.println("jamil---------------"+product);

	    // Get the cart
	    Cart cart = cartRepository.findByCartId(cartItemRequest.getCartId());
	    if (cart == null) {
	        throw new CustomException("Cart not found");
	    }

	    // Create new cart item and set properties
	    CartItem cartItem = new CartItem();
//	    cartItem.setProduct(product);
	    cartItem.setCart(cart);  // Associate the cartItem with the cart
	    cartItem.setQuantity(cartItemRequest.getQuantity());

	    double cartItemsTotalPrice = cartItem.getQuantity() * cartItem.getCartItemsTotalPrice();
//	    		getProduct().get(0).getProductPrice();
//	    		.getProductPrice();
	    cartItem.setCartItemsTotalPrice(cartItemsTotalPrice);
	    cartItem.setCreatedBy(cartItemRequest.getCreatedBy());
	    cartItem.setCreatedDate(LocalDateTime.now());
	    cartItem.setUpdatedBy(cartItemRequest.getUpdatedBy());
	    cartItem.setUpdatedDate(LocalDateTime.now());

	    // Save the cart item
	    cartItem = cartItemRepository.save(cartItem);

	    // Update cart totals
	    recalculateCartTotals(cart.getCartId());

	    return mapToResponse(cartItem);
	}
	

//	@Override
//	public CartItemResponse addCartItem(CartItemRequest cartItemRequest) {
//		
////		Product product = productRepository.getById(null)
//		
////		@SuppressWarnings("deprecation")
//		Product product = productRepository.findByProductId(cartItemRequest.getProductId());
//		System.out.println("jamil---------------"+product);
//				
//		
////		Product product = productRepository.findByProductId(cartItemRequest.getProductId())
////				.orElseThrow(() -> new CustomException("Customer not found"));
//		
//		CartItem cartItem = new CartItem();
////		Cart cart = new Cart();
//		cartItem.setProduct(product);
////		cartItem.setCart(cart.getCartId());
//		cartItem.setQuantity(cartItemRequest.getQuantity());
//		
//		double cartItemsTotalPrice = cartItem.getQuantity() * cartItem.getProduct().getProductPrice();
//		cartItem.setCartItemsTotalPrice(cartItemsTotalPrice);
//		cartItem.setCreatedBy(cartItemRequest.getCreatedBy());
//		cartItem.setCreatedDate(LocalDateTime.now());
//		cartItem.setUpdatedBy(cartItemRequest.getUpdatedBy());
//		cartItem.setUpdatedDate(LocalDateTime.now());
//		
//		cartItem = cartItemRepository.save(cartItem);
//		
////		recalculateCartTotals(cartItem.getCartId());
//		
//		return mapToResponse(cartItem);
//		
//	}

	@Override
	public CartItemResponse updateCartItem(long cartItemId, CartItemRequest cartItemRequest) {
		CartItem updatedCartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
//		List<Product> product = productRepository.findById(cartItemRequest.getProductId())
//				.orElseThrow(() -> new CustomException("Customer not found"));
		
	    List<Product> product = productRepository.findByProductId(cartItemRequest.getProductId());

		
//		updatedCartItem.setProduct(product);
		updatedCartItem.setQuantity(cartItemRequest.getQuantity());
		
		double cartItemsTotalPrice = updatedCartItem.getQuantity() * updatedCartItem.getCartItemsTotalPrice();
//				getProduct().get(0).getProductPrice();
//				getProductPrice();

		updatedCartItem.setCartItemsTotalPrice(cartItemsTotalPrice);
		updatedCartItem.setUpdatedBy(cartItemRequest.getUpdatedBy());
		updatedCartItem.setUpdatedDate(LocalDateTime.now());
		
		updatedCartItem = cartItemRepository.save(updatedCartItem);
		
		recalculateCartTotals(updatedCartItem.getCart().getCartId());

		
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
		recalculateCartTotals(cartItem.getCart().getCartId());

		
	}
	
	
	private void recalculateCartTotals(long cartId) {
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new CustomException("Cart not found"));
		
		Optional<List<CartItem>> cartItemsOptional = Optional.of(cartItemRepository.findAll());
		List<CartItem> cartItems = cartItemsOptional.orElse(Collections.EMPTY_LIST);
		
		
		double subTotal = 0.00;
		double totalTax = 0.00;
		
		for(CartItem cartItem : cartItems) {
			double itemTotalPrice = cartItem.getCartItemsTotalPrice()* cartItem.getQuantity(); 
//					getProduct().get(0).getProductPrice() * cartItem.getQuantity(); 
			double itemTax = itemTotalPrice;
//			double itemTax = itemTotalPrice * cartItem.getProduct().get(0).getTaxRate() / 100;
//					getTaxRate() / 100;
			
			subTotal = subTotal + itemTotalPrice;
			totalTax = totalTax + itemTax;
		}	
		
		double discountAmount = cart.getDiscountAmount() != 0 ? cart.getDiscountAmount() : 0;
		double totalPrice = subTotal + totalTax + cart.getShippingFee() - discountAmount;
		
		cart.setSubTotal(subTotal);
		cart.setTaxAmount(totalTax);
		cart.setTotalPrice(totalPrice);
		
		cartRepository.save(cart);
		
	}
	
	
	
	private CartItemResponse mapToResponse(CartItem cartItem) {
		CartItemResponse cartItemResponse = new CartItemResponse();
		cartItemResponse.setCartItemId(cartItem.getCartItemId());
		cartItemResponse.setCartId(cartItem.getCart().getCartId());
//		cartItemResponse.setProductId(cartItem.get
//				.get(0).getProductId());
		cartItemResponse.setQuantity(cartItem.getQuantity());
		cartItemResponse.setCartItemsTotalPrice(cartItem.getCartItemsTotalPrice());
		cartItemResponse.setCreatedBy(cartItem.getCreatedBy());
		cartItemResponse.setCreatedDate(cartItem.getCreatedDate());
		cartItemResponse.setUpdatedBy(cartItem.getUpdatedBy());
		cartItemResponse.setUpdatedDate(cartItem.getUpdatedDate());
		
		return cartItemResponse;
	
		
	}



}
