package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.altran.TOOLSBox_Systeme_De_Management.model.User;

public interface UserService {

	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int idUser);

	User getUserById(int idUser);

	Page<User> getAllUsers(int page);

	User getUserByUsername(String username);
}
