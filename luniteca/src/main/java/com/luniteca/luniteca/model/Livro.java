package com.luniteca.luniteca.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo titulo é obrigatório e não pode utilizar espações em branco")
	@Size(max = 45, message = "O atributo titulo deve conter no máximo 100 caracteres")
	@Column(unique=true)
	private String titulo;
	
	@Size(max = 45, message = "O atributo categoria deve conter no máximo 100 caracteres")
	private String categoria;
	
	@Size(max = 45, message = "O atributo autor deve conter no máximo 100 caracteres")
	private String autor;
	
	@NotNull(message = "O atributo codigo é obrigatório e não pode utilizar espações em branco")
	@Column(unique=true)
	private long codigo;
	
	private int numeroPagina;
	
	@Min(0)
	private int quantidadeEstoque;
	
	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private List<Emprestimo> emprestimo;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}

}
