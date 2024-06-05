/**
 * 
 */
package com.ecommerce.shoppingcart.payload.request;

/**
 * 
 */
public class CustomerRequest {
	
	private String customerName;
	private String email;
	private String password;
//	private long roleId;
	/**
	 * @return the userName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the roleId
	 */
//	public long getRoleId() {
//		return roleId;
//	}
//	/**
//	 * @param roleId the roleId to set
//	 */
//	public void setRoleId(long roleId) {
//		this.roleId = roleId;
//	}
	
	

}
