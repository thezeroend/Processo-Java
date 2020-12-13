package com.itau.oauth.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.itau.oauth.domain.Authorities;
import com.itau.oauth.model.Role;
import com.itau.oauth.model.User;
import com.itau.oauth.repository.RoleRepository;
import com.itau.oauth.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        List<User> users = userRepository.findAll();
        
        if (users.isEmpty()) {
        	createUser("Admin", "admin", passwordEncoder.encode("123456"), Authorities.ROLE_ADMIN);
            createUser("Cliente", "cliente", passwordEncoder.encode("123456"), Authorities.ROLE_CLIENT);
        }

    }

    public void createUser(String nome, String user, String password, String roleName) {

        Role role = new Role(roleName);

        this.roleRepository.save(role);
        User usuario = new User(nome, user, password, Arrays.asList(role));
        userRepository.save(usuario);
    }

}

