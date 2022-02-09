package br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.controller;

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

import br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.model.Estabelecimento;
import br.com.mapeamentocicloamigavel.mapeamentoCicloAmigavel.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/estabelecimento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstabelecimentoController {

	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Estabelecimento>> getAllEstabelecimento() {
		return ResponseEntity.ok(estabelecimentoRepository.findAll());
		
		
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Estabelecimento>> getByNome(@PathVariable String estabelecimento) {
		return ResponseEntity.ok(estabelecimentoRepository.findAllByNomeContainingIgnoreCase(estabelecimento));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estabelecimento> getById(@PathVariable long id) {
		return estabelecimentoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Estabelecimento> postTema(@Valid @RequestBody Estabelecimento estabelecimento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoRepository.save(estabelecimento));
	}

	@PutMapping
	public ResponseEntity<Estabelecimento> putTema(@Valid @RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoRepository.findById(estabelecimento.getId_estabelecimento())
				.map(resposta -> ResponseEntity.ok().body(estabelecimentoRepository.save(estabelecimento)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTema(@PathVariable long id) {
		return estabelecimentoRepository.findById(id).map(resposta -> {
			estabelecimentoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
}
}
