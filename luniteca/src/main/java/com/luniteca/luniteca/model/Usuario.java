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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo nome é obrigatório e não pode utilizar espações em branco")
	@Size(max = 100, message = "O atributo nome deve conter no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo endereco é obrigatório e não pode utilizar espações em branco")
	@Size(max = 100, message = "O atributo endereco deve conter no máximo 100 caracteres")
	private String endereco;
	
	@NotBlank(message = "O atributo cpf é obrigatório e não pode utilizar espações em branco")
	@Column(unique=true)
	private long cpf; 
	
	@NotBlank(message = "O atributo email é obrigatório e não aceita espaços vazios")
	@Size(max = 255, message = "O atributo Email permite no máximo 255 caracteres")
	@Email
	@Column(unique=true)
	private String email;
	
	@NotNull(message = "O atributo senha não pode ser vázio")
	@Size(min = 8, message = "O atributo senha exige no minimo 8 caracteres")
	private String senha;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Emprestimo> emprestimo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}

	
}
