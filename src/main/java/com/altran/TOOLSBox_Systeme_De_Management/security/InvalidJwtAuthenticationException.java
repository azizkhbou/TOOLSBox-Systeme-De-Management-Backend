package com.altran.TOOLSBox_Systeme_De_Management.security;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
	public InvalidJwtAuthenticationException(String e) {
		super(e);
	}
}