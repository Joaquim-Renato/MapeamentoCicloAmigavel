package br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.model.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{

	public List <Estabelecimento> findAllByNomeContainingIgnoreCase(String nome);
}
