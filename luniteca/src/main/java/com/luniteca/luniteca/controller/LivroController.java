package com.luniteca.luniteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luniteca.luniteca.model.Livro;
import com.luniteca.luniteca.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public ResponseEntity<List<Livro>> getAll(){
		return ResponseEntity.ok(livroRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> getById(@PathVariable long id) {
		return livroRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Livro>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(livroRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Livro>> getByCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(livroRepository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@GetMapping("/autor/{autor}")
	public ResponseEntity<List<Livro>> getByAutor(@PathVariable String autor) {
		return ResponseEntity.ok(livroRepository.findAllByAutorContainingIgnoreCase(autor));
	}
	
	/*@GetMapping("/codigo/{codigo}")
	private ResponseEntity<Livro> getByCodigo(@PathVariable int codigo){
		return ResponseEntity.ok(livroRepository.findByCodigo(codigo));
	}*/
	
	@PostMapping
	public ResponseEntity<Livro> postLivro(@Valid @RequestBody Livro livro){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
	}
	
	@PutMapping
	public ResponseEntity<Livro> putPostagem(@Valid @RequestBody Livro livro){

		return livroRepository.findById(livro.getId())
				.map(resposta -> ResponseEntity.ok().body(livroRepository.save(livro)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLivro(@PathVariable long id){

		return livroRepository.findById(id).map(resposta ->{
			livroRepository.deleteById(id);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
