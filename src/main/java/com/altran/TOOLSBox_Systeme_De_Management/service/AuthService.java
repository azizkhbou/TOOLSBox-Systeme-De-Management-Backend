package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

	List<String> getPrivileges(UserDetails userDetails);
}
