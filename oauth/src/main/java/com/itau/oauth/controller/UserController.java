package com.itau.oauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.oauth.domain.Authorities;
import com.itau.oauth.model.User;
import com.itau.oauth.repository.RoleRepository;
import com.itau.oauth.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Secured({Authorities.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
    	try {
	    	user.setPassword(passwordEncoder.encode(user.getPassword()));
	        user = this.userRepository.save(user);
	        
	        return ResponseEntity.ok().body(user);
    	} catch (Exception ex) {
    		return ResponseEntity.badRequest().build();
    	}
    }

    @Secured({Authorities.ROLE_ADMIN})
    @PutMapping(value="/{id}")
    public ResponseEntity<User> edit(@PathVariable("id") long id, @RequestBody User user){
        return userRepository.findById(id)
			.map(record -> {
				record.setNome(user.getNome());
				User updated = userRepository.save(record);
				return ResponseEntity.ok().body(updated);
			}).orElse(ResponseEntity.notFound().build());
    }

}
