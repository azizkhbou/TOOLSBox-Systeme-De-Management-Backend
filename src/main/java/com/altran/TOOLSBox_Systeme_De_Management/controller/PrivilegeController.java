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

import com.altran.TOOLSBox_Systeme_De_Management.model.Privilege;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.PrivilegeServiceImp;

@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {

	private PrivilegeServiceImp privilegeServiceImp;

	@Autowired
	public void setPrivilegeServiceImp(PrivilegeServiceImp privilegeServiceImp) {
		this.privilegeServiceImp = privilegeServiceImp;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PostMapping(value = "/create")
	public boolean createUser(@RequestBody Privilege privilege) {

		return privilegeServiceImp.addPrivilege(privilege);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PutMapping(value = "/update")
	public boolean updatePrivilege(@RequestBody int id,Privilege privilege) {

		return privilegeServiceImp.updatePrivilege(id,privilege);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@DeleteMapping(value = "/delete/{id}")
	public boolean deletePrivilege(@PathVariable int id) {

		return privilegeServiceImp.deletePrivilege(id);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@GetMapping(value = "/all")
	public List<Privilege> getAllPrivileges() {

		return privilegeServiceImp.getAllPrivileges();

	}

	@GetMapping(value = "/id/{id}")
	public Privilege getPrivilegeById(@PathVariable int id) {
		return privilegeServiceImp.getPrivilegeById(id);
	}

}