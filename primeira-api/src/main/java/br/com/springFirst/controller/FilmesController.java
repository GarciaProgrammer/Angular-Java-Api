package br.com.springFirst.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springFirst.entity.Filme;
import br.com.springFirst.repository.FilmeRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FilmesController {

	@Autowired
	private FilmeRepository filmeRepository;

	@GetMapping("/filmes")
	public List<Filme> geetAllFilmes() {
		return filmeRepository.findAll();
	}

	@GetMapping("/filmes/{id}")
	public ResponseEntity<Filme> getFilmeId(@Valid @PathVariable("id") Long idFilme) throws Exception {
		Filme filme = filmeRepository.findById(idFilme).orElseThrow(
				() -> new Exception("Filme não encontrado" + idFilme));
		return ResponseEntity.ok().body(filme);
	}
}
