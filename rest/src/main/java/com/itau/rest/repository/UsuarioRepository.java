package com.itau.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itau.rest.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT user FROM Usuario as u WHERE LOWER(u.user) = LOWER(:user)")
    Optional<Usuario> findByUsername(@Param("user") String user);
}
