package com.spring.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.model.RegistrationFlow;
import com.spring.persistence.RegistrationFlowRepository;

@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private RegistrationFlowRepository registrationFlowRepository;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		final RegistrationFlow userModel = registrationFlowRepository.findByEmail(email);
		
		if(userModel==null) {
			throw new UsernameNotFoundException("No User found with username "+email);
		}
		return new org.springframework.security.core.userdetails.User(userModel.getEmail(),userModel.getPassword(),userModel.getEnabled(),true,true,true, getAuthorities("ROLE_USER"));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

}
