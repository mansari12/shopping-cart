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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoppingcart.payload.request.RoleRequest;
import com.ecommerce.shoppingcart.payload.response.RoleResponse;
import com.ecommerce.shoppingcart.service.RoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * 
 */
@RestController
@RequestMapping("/v1/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	@PostMapping("/createRole")
	public RoleResponse createRole(@RequestBody RoleRequest roleRequest) {
		return roleService.createRole(roleRequest);
	}
	
	
	@PutMapping("/{roleId}")
	public RoleResponse updateRole(@PathVariable long roleId, RoleRequest roleRequest) {
		return roleService.updateRole(roleId, roleRequest);
	}
	
	
	@GetMapping("/{roleId}")
	public RoleResponse getRoleById(@PathVariable long roleId) {
		return roleService.getRoleById(roleId);
	}
	
	
	@GetMapping("/getAllRoles")
	public List<RoleResponse> getAllRoles(){
		return roleService.getAllRoles();
		
	}
	
	@DeleteMapping("/{roleId}")
	public void deleteRole(@PathVariable long roleId) {
		roleService.deleteRole(roleId);
		
	}
	
}	
	
