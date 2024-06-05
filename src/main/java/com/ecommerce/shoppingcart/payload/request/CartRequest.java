/**
 * 
 */
package com.ecommerce.shoppingcart.payload.request;

import java.time.LocalDateTime;

import com.ecommerce.shoppingcart.model.Cart.Status;
import com.ecommerce.shoppingcart.repository.ProductRepository;

/**
 * 
 */
public class CartRequest {
	
	private long customerId;
	private double subTotal;
	private double discountAmount;
	private double taxAmount;
	private double shippingFee;
//	private double totalPrice;]
	private Status status;
//	private String createdBy;
	private LocalDateTime createdDate;
//	private String updatedBy;
	private LocalDateTime updatedDate;
	
//	private ProductRepository product;
//	private CartItemRequest cartItemRequest;
	
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}
	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}
	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	/**
	 * @return the taxAmount
	 */
	public double getTaxAmount() {
		return taxAmount;
	}
	/**
	 * @param taxAmount the taxAmount to set
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	/**
	 * @return the shippingFee
	 */
	public double getShippingFee() {
		return shippingFee;
	}
	/**
	 * @param shippingFee the shippingFee to set
	 */
	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}
	/**
	 * @return the totalPrice
	 */
//	public double getTotalPrice() {
//		return totalPrice;
//	}
//	/**
//	 * @param totalPrice the totalPrice to set
//	 */
//	public void setTotalPrice(double totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the createdBy
	 */
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	/**
//	 * @param createdBy the createdBy to set
//	 */
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the updatedBy
//	 */
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//	/**
//	 * @param updatedBy the updatedBy to set
//	 */
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}
	/**
	 * @return the updatedDate
	 */
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
