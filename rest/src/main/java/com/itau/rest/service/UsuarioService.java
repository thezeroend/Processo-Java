package com.itau.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itau.rest.model.Usuario;
import com.itau.rest.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
