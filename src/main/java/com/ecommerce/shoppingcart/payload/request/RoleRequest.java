package com.ecommerce.shoppingcart.payload.request;

import org.springframework.stereotype.Component;

@Component
public class RoleRequest {
	
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
