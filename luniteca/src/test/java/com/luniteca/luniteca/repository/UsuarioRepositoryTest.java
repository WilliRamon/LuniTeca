package com.luniteca.luniteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.luniteca.luniteca.model.Usuario;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0L, "João da Silva", "Rua Jandira", 12345678910l, "joao@email.com.br", "13465278", "normal"));
		
		usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "Rua Osasco", 12345678911l, "manuela@email.com.br", "13465278", "normal"));
		
		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "Rua Barueri", 12345678912l, "adriana@email.com.br", "13465278", "normal"));

        usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "Rua Barueri", 12345678913l, "paulo@email.com.br", "13465278", "normal"));

	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByEmail("joao@email.com.br");
		assertTrue(usuario.get().getEmail().equals("joao@email.com.br"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
		
	}
}
