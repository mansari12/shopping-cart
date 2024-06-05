package com.ecommerce.shoppingcart.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CART")
@SequenceGenerator(name="cart_id_seq", initialValue=31, allocationSize=100)
public class Cart {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_id_seq")
	@Column(name = "CART_ID")
	private long cartId;
	
	@OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@Column(name = "SUB_TOTAL")
	private double subTotal;
	
	@Column(name = "DISCOUNT_AMOUNT")
	private double discountAmount;
	
	@Column(name = "TAX_AMOUNT")
	private double taxAmount;
	
	@Column(name = "SHIPPING_FEE")
	private double shippingFee;
	
	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	public enum Status { 
		ACTIVE, SAVED
	}

	/**
	 * 
	 */
	public Cart() {
		super();
	}

	

	/**
	 * @param cartId
	 * @param cartItems
	 * @param customer
	 * @param subTotal
	 * @param discountAmount
	 * @param taxAmount
	 * @param shippingFee
	 * @param totalPrice
	 * @param status
	 * @param createdBy
	 * @param createdDate
	 * @param updatedBy
	 * @param updatedDate
	 */
	public Cart(long cartId, List<CartItem> cartItems, Customer customer, double subTotal, double discountAmount,
			double taxAmount, double shippingFee, double totalPrice, Status status, String createdBy,
			LocalDateTime createdDate, String updatedBy, LocalDateTime updatedDate) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.customer = customer;
		this.subTotal = subTotal;
		this.discountAmount = discountAmount;
		this.taxAmount = taxAmount;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}



	/**
	 * @return the cartId
	 */
	public long getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

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
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

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
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

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

	/**
	 * @return the cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}



	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", customer=" + customer + ", subTotal="
				+ subTotal + ", discountAmount=" + discountAmount + ", taxAmount=" + taxAmount + ", shippingFee="
				+ shippingFee + ", totalPrice=" + totalPrice + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
		

}
