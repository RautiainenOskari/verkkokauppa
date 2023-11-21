package com.projekti.verkkokauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projekti.verkkokauppa.domain.User;
import com.projekti.verkkokauppa.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository uRepository) {
		this.repository = uRepository;
	}
	
	@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User currentUser = repository.findByusername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
		
}
