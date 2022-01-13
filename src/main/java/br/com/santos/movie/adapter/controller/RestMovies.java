package br.com.santos.movie.adapter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santos.movie.adapter.controller.model.MovieDTO;
import br.com.santos.movie.domain.ServiceMovie;
import lombok.AllArgsConstructor;

@RequestMapping("/movies")
@RestController
@AllArgsConstructor
public class RestMovies {

	private final ServiceMovie serviceMovie;
	
	@GetMapping("/awards")
	public ResponseEntity<List<MovieDTO>> listWinners() {
	
		var list = serviceMovie.listWinners()
				.stream()
				.map(MovieDTO::criar)
				.collect(Collectors.toList());

		return ResponseEntity.ok(list); 
	}
}
