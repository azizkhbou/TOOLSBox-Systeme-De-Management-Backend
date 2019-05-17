package com.altran.TOOLSBox_Systeme_De_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.altran.TOOLSBox_Systeme_De_Management.repository.UserRepository;
import com.altran.TOOLSBox_Systeme_De_Management.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Autowired
	public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	AuthenticationManager authenticationManager;

	JwtTokenProvider jwtTokenProvider;

	UserRepository userRepository;

	@PostMapping("/signin")
	public ResponseEntity signin(@RequestBody AuthenticationRequest data) {

		try {
			String username = data.getUsername();
			String password = data.getPassword();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			String token = jwtTokenProvider.createToken(username,
					userRepository.findByUsername(username)
							.orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"))
							.getRoles().stream().map(role -> role.getPrivileges().stream()
									.map(privilege -> privilege.getTitle()).collect(Collectors.toSet()))
							.collect(Collectors.toList()));
			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}
	}
}
