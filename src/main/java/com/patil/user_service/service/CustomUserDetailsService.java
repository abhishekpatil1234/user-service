package com.patil.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.patil.user_service.entity.UserDetailsEntity;
import com.patil.user_service.repository.UserDetailsRepository;
import org.springframework.security.core.GrantedAuthority;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsEntity userDetailsEntity = userDetailsRepository.findByEmail(username).orElseThrow(()->
				new UsernameNotFoundException("User details not found for the user:"+username));
		List<GrantedAuthority> authoritiesList = List.of(new SimpleGrantedAuthority(userDetailsEntity.getRole()));
		return new User(userDetailsEntity.getEmail(), userDetailsEntity.getPassword(), authoritiesList);
	}

}
