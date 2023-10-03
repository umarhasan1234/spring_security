package com.securityDemo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.securityDemo.entity.UserEntity;
import com.securityDemo.repository.UserRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUserName(userName)
		.orElseThrow(()->new UsernameNotFoundException("user  name not found"));
		return new UserDetailsImpl(user);
	}

}
