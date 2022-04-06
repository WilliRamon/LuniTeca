package com.luniteca.luniteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luniteca.luniteca.model.Usuario;
import com.luniteca.luniteca.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id) {
		return usuarioRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<Usuario>> getByEmail(@PathVariable String email) {
		return ResponseEntity.ok(usuarioRepository.findAllByEmailContainingIgnoreCase(email));
	}
}
