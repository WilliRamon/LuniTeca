package com.luniteca.luniteca.controller;

import java.util.Date;
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

import com.luniteca.luniteca.model.Emprestimo;
import com.luniteca.luniteca.repository.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimo")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> getAll(){
		return ResponseEntity.ok(emprestimoRepository.findAll());
	}
	
	@GetMapping("/dataEmprestimo/{dataEmprestimo}")
	public ResponseEntity<List<Emprestimo>> getByDataEmprestimo(@PathVariable Date dataEmprestimo) {
		return ResponseEntity.ok(emprestimoRepository.findAllByDataEmprestimoContaining(dataEmprestimo));
	}
	
	@GetMapping("/dataEntre/{inicio}/{fim}")
	public ResponseEntity<List<Emprestimo>> getByDataEntre(@PathVariable Date inicio, @PathVariable Date fim) {
		return ResponseEntity.ok(emprestimoRepository.findByDataEmprestimoBetween(inicio, fim));
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> postEmprestimo(@Valid @RequestBody Emprestimo emprestimo){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoRepository.save(emprestimo));
	}
	
	@PutMapping
	public ResponseEntity<Emprestimo> putEmprestimo(@Valid @RequestBody Emprestimo emprestimo){

		return emprestimoRepository.findById(emprestimo.getId())
				.map(resposta -> ResponseEntity.ok().body(emprestimoRepository.save(emprestimo)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmprestimo(@PathVariable long id){

		return emprestimoRepository.findById(id).map(resposta ->{
			emprestimoRepository.deleteById(id);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
