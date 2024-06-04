/**
 * 
 */
package com.ecommerce.shoppingcart.service;

import java.util.List;

import com.ecommerce.shoppingcart.payload.request.RoleRequest;
import com.ecommerce.shoppingcart.payload.response.RoleResponse;

/**
 * 
 */

public interface RoleService {
	
	RoleResponse createRole(RoleRequest roleRequest);
	RoleResponse updateRole(long roleId, RoleRequest roleRequest);
	RoleResponse getRoleById(long roleId);
	List<RoleResponse> getAllRoles();
	void deleteRole(long roleId);
}
	