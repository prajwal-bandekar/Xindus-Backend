package org.xindus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.xindus.config.UserToUserDetails;
import org.xindus.entity.User;
import org.xindus.repository.UserRepository;

@Component
public class UserToUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Optional<User> user = repository.findByName(email);
	
	return user.map(UserToUserDetails:: new)
	.orElseThrow(() -> new UsernameNotFoundException("Wrong Email Entered " + email));
	}

}
