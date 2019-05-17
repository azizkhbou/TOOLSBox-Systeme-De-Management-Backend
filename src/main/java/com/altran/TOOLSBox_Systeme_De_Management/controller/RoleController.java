package com.altran.TOOLSBox_Systeme_De_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
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
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	private RoleServiceImp roleServiceImp;

	@Autowired
	public void setRoleServiceImp(RoleServiceImp roleServiceImp) {
		this.roleServiceImp = roleServiceImp;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@GetMapping(value = "/all")
	public MappingJacksonValue getAllRoles() {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.ROLE_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.PRIVILEGES));
		MappingJacksonValue rolesMapping = new MappingJacksonValue(roleServiceImp.getAllRoles());
		rolesMapping.setFilters(filterProvider);
		return rolesMapping;
	}

	@GetMapping(value = "/id/{id}")
	public MappingJacksonValue getRoleById(@PathVariable int id) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.ROLE_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		MappingJacksonValue rolesMapping = new MappingJacksonValue(roleServiceImp.getAllRoles());
		rolesMapping.setFilters(filterProvider);
		return rolesMapping;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PostMapping(value = "/create")
	public boolean createUser(@RequestBody Role role) {

		return roleServiceImp.addRole(role);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PutMapping(value = "/update/{id}")
	public boolean updateRole(@PathVariable int id, @RequestBody Role role) {

		return roleServiceImp.updateRole(id, role);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteRole(@PathVariable int id) {

		return roleServiceImp.deleteRole(id);

	}

}
