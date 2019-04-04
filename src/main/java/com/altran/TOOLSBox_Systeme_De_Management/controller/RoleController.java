package com.altran.TOOLSBox_Systeme_De_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.Role;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.RoleServiceImp;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	private RoleServiceImp roleServiceImp;

	@Autowired
	public void setRoleServiceImp(RoleServiceImp roleServiceImp) {
		this.roleServiceImp = roleServiceImp;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PostMapping(value = "/create")
	public boolean createUser(@RequestBody Role role) {

		return roleServiceImp.addRole(role);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PutMapping(value = "/update")
	public boolean updateRole(@RequestBody Role role) {

		return roleServiceImp.updateRole(role);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteRole(@PathVariable int id) {

		return roleServiceImp.deleteRole(id);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@GetMapping(value = "/all")
	public List<Role> getAllRoles() {

		return roleServiceImp.getAllRoles();

	}

	@GetMapping(value = "/id/{id}")
	public Role getRoleById(@PathVariable int id) {
		return roleServiceImp.getRoleById(id);
	}
}
