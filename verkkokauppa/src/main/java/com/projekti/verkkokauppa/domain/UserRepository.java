package com.projekti.verkkokauppa.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByusername(String username);
}
