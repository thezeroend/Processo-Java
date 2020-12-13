package com.itau.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.oauth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByNome(String nome);

}
