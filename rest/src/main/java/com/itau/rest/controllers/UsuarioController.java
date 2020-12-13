package com.itau.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.rest.model.Usuario;
import com.itau.rest.repository.UsuarioRepository;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long id) {
		return usuarioRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Usuario usuario) {
		try {
			Usuario response = usuarioRepository.save(usuario) ;
			return new ResponseEntity<Usuario> (response, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<Usuario> (HttpStatus.EXPECTATION_FAILED);
		}
	}
		
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		return usuarioRepository.findById(id)
				.map(record -> {
					record.setNome(usuario.getNome());
					Usuario updated = usuarioRepository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	} 
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
		return usuarioRepository.findById(id)
				.map(record -> {
					usuarioRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
