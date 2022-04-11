package com.luniteca.luniteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luniteca.luniteca.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail(String usuario);

	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	
	public Usuario findByCpf (Long cpf);	
	
	public List<Usuario> findAllByEmailContainingIgnoreCase (String email);
}
