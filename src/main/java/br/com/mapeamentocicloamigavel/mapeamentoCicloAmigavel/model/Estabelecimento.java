package br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="tb_estabelecimento")
public class Estabelecimento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_estabelecimento;
	
	
	@NotNull (message = "O atributo nome é Obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo nome deve conter no mínimo 05 e no máximo 50 caracteres")
	private String nome;
	
//	@NotNull (message = "O atributo banheiro é Obrigatório!")
//	@Size(min = 5, max = 10, message = "min= 5, max= 10")
//	private String banheiro;
//	
//	@NotNull (message = "O atributo tomada é Obrigatório!")
//	@Size(min = 5, max = 10, message = "min= 5, max= 10")
//	private String tomada;
	
	@Size(min = 5, max = 140, message = "O atributo descrição deve conter no min= 5, max= 250")
	private String descricao;
	

	@Size(min = 10, max = 255)
	private String imagem;


	public long getId_estabelecimento() {
		return id_estabelecimento;
	}


	public void setId_estabelecimento(long id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
