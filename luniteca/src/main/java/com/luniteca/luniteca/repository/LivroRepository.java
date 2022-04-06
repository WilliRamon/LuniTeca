 package com.luniteca.luniteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luniteca.luniteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	public List<Livro> findAllByTituloContainingIgnoreCase (String titulo);
	
	public List<Livro> findAllByCategoriaContainingIgnoreCase (String categoria);
	
	public List<Livro> findAllByAutorContainingIgnoreCase (String autor);
	
	/*public Livro findByCodigo (Integer codigo);*/
}
 