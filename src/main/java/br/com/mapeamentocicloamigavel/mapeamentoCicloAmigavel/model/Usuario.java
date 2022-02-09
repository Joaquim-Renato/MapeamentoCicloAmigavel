package br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@NotNull(message = "O atributo Nome é Obrigatório!")
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no min 3 e no max 100 caracteres!")
	private String nome;
	
	@NotNull(message = "O atributo usuario é Obrigatório!")
	@Email( message = "O atributo usuario deve conter um email valido!")
	private String usuario;
	
	@NotNull(message = "O atributo senha é Obrigatório!")
	@Size(min = 6, message = "O atributo senha deve conter no mínimo 06 caracteres")
	private String senha;

	private String foto;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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
