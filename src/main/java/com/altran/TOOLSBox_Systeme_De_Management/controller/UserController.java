package com.altran.TOOLSBox_Systeme_De_Management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.User;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.UserServiceImp;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserServiceImp userServiceImp;

	@Autowired
	public void setUserServiceImp(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PostMapping(value = "/create")
	public boolean createUser(@RequestBody User user) {

		return userServiceImp.addUser(user);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PutMapping(value = "/update")
	public boolean updateUser(@RequestBody User user) {

		return userServiceImp.updateUser(user);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteUser(@PathVariable int id) {

		return userServiceImp.deleteUser(id);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@GetMapping(value = "/all/{page}")
	public Page<User> getAllUsers(@PathVariable int page) {

		return userServiceImp.getAllUsers(page);

	}

	@GetMapping(value = "username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userServiceImp.getUserByUsername(username);
	}
	
	@GetMapping(value = "/id/{idUser}")
	public User getUserById(@PathVariable int idUser) {
		return userServiceImp.getUserById(idUser);
	}
}
