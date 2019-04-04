package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.User;
import com.altran.TOOLSBox_Systeme_De_Management.repository.UserRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.UserService;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

	private UserRepository userRepository;

	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setBcryptEncoder(BCryptPasswordEncoder bcryptEncoder) {
		this.bcryptEncoder = bcryptEncoder;
	}

	@Override
	public boolean addUser(User user) {
		try {
			System.out.println("sqdqsd");
			System.out.println(user.getRoles().size());
			String password = user.getPassword();
			password = bcryptEncoder.encode(password);
			user.setPassword(password);
			userRepository.save(user);
			
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean updateUser(User user) {
		try {

			userRepository.save(user);

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean deleteUser(int idUser) {
		try {
			userRepository.deleteById(idUser);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public User getUserById(int idUser) {
		return userRepository.findById(idUser).orElse(null);

	}

	@Override
	public Page<User> getAllUsers(int page) {

		return userRepository.findAll(new PageRequest(page, 6,Direction.ASC,"prenom","nom"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set getAuthority(User user) {
		Set authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			role.getPrivileges().forEach(privilege -> {
				authorities.add(new SimpleGrantedAuthority(privilege.getTitre()));
			});
		});
		return authorities;
	}

	@Override
	public User getUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();
		if (user == null)
			throw new UsernameNotFoundException("Invalid username or password.");
		return user;
	}
}
