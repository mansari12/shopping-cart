/**
 * 
 */
package com.ecommerce.shoppingcart.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppingcart.model.Role;
import com.ecommerce.shoppingcart.payload.request.RoleRequest;
import com.ecommerce.shoppingcart.payload.response.RoleResponse;
import com.ecommerce.shoppingcart.repository.RoleRepository;
import com.ecommerce.shoppingcart.service.RoleService;
import com.ecommerce.shoppingcart.service.exception.CustomException;

/**
 * 
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public RoleResponse createRole(RoleRequest roleRequest) {
		Role role = new Role();
		role.setRoleName(roleRequest.getRoleName());
		role.setCreatedBy("system");
		role.setCreatedDate(LocalDateTime.now());
		role.setUpdatedBy("system");
		role.setUpdatedDate(LocalDateTime.now());
		roleRepository.save(role);
		
		return mapToResponse(role);
	}

	@Override
	public RoleResponse updateRole(long roleId, RoleRequest roleRequest) {
		Role role = roleRepository.findById(roleId).orElseThrow(() -> new CustomException("Role not found"));
		role.setRoleName(roleRequest.getRoleName());
		role.setUpdatedBy("system");
		role.setUpdatedDate(LocalDateTime.now());
		roleRepository.save(role);
		
		return mapToResponse(role);
	}

	@Override
	public RoleResponse getRoleById(long roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow(() -> new CustomException("Role not found"));
		return mapToResponse(role);
	}

	@Override
	public List<RoleResponse> getAllRoles() {
		List<Role> roles = roleRepository.findAll();
		
		return roles.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public void deleteRole(long roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow(() -> new CustomException("Role not found"));
		roleRepository.delete(role);
	}
	
	private RoleResponse mapToResponse(Role role) {
		RoleResponse roleResponse = new RoleResponse();
		roleResponse.setRoleId(role.getRoleId());
		roleResponse.setRoleName(role.getRoleName());
		roleResponse.setCreatedBy(role.getCreatedBy());
		roleResponse.setCreatedDate(role.getCreatedDate());
		roleResponse.setUpdatedBy(role.getUpdatedBy());
		roleResponse.setUpdateDate(role.getUpdatedDate());
		
		return roleResponse;
	}

}
