package com.luniteca.luniteca.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luniteca.luniteca.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
	
	public List<Emprestimo> findAllByDataEmprestimoContaining (Date dataEmprestimo);
	
	public List<Emprestimo> findByDataEmprestimoBetween(Date inicio, Date fim);

}
