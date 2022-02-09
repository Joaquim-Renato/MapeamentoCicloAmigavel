package br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	
	public List <Postagem> findAllByTextoContainingIgnoreCase(String texto);

}
