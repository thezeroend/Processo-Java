package com.itau.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.oauth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUser(String user);
    
}
