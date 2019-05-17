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

import com.altran.TOOLSBox_Systeme_De_Management.model.User;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.UserServiceImp;
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserServiceImp userServiceImp;

	@Autowired
	public void setUserServiceImp(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@GetMapping(value = "/all/{page}")
	public MappingJacksonValue getAllUsers(@PathVariable int page) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.USER_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		filterProvider.addFilter(Constants.ROLE_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.PRIVILEGES));
		MappingJacksonValue usersMapping = new MappingJacksonValue(userServiceImp.getAllUsers(page));
		usersMapping.setFilters(filterProvider);
		return usersMapping;
	}

	@GetMapping(value = "username/{username}")
	public MappingJacksonValue getUserByUsername(@PathVariable String username) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.USER_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		filterProvider.addFilter(Constants.ROLE_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.PRIVILEGES));
		MappingJacksonValue usersMapping = new MappingJacksonValue(userServiceImp.getUserByUsername(username));
		usersMapping.setFilters(filterProvider);
		return usersMapping;
	}

	@GetMapping(value = "/id/{idUser}")
	public MappingJacksonValue getUserById(@PathVariable int idUser) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.USER_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		filterProvider.addFilter(Constants.ROLE_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.PRIVILEGES));
		MappingJacksonValue usersMapping = new MappingJacksonValue(userServiceImp.getUserById(idUser));
		usersMapping.setFilters(filterProvider);
		return usersMapping;
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PostMapping(value = "/create")
	public boolean createUser(@RequestBody User user) {

		return userServiceImp.addUser(user);
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PutMapping(value = "/update/{id}")
	public boolean updateUser(@PathVariable int id, @RequestBody User user) {

		return userServiceImp.updateUser(id, user);
	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteUser(@PathVariable int id) {

		return userServiceImp.deleteUser(id);
	}

}
