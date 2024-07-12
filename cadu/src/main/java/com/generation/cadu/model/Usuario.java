package com.generation.cadu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório!!!!")
	@Size(min = 1, max = 255, message = "O nome deve possuir entre 1 e 255 caracteres")
	private String nome;
	
	
	@NotBlank(message = "O e-mail é obrigatório!!!!")
	@Size(min = 1, max = 255, message = "O e-mail deve possuir entre 1 e 255 caracteres")
	private String usuario;
	
	@NotBlank(message = "A senha é obrigatório!!!!")
	@Size(min = 6, max = 255, message = "A senha deve possuir entre 6 e 255 caracteres")
	private String senha;
	
	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	

	
	

}
