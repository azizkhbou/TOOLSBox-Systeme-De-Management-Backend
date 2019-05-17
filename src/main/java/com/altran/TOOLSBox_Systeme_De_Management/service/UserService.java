package com.altran.TOOLSBox_Systeme_De_Management.service;

import org.springframework.data.domain.Page;

import com.altran.TOOLSBox_Systeme_De_Management.model.User;

public interface UserService {

	Page<User> getAllUsers(int page);

	User getUserById(int idUser);

	User getUserByUsername(String username);

	boolean addUser(User user);

	boolean updateUser(int id, User user);

	boolean deleteUser(int idUser);

}
