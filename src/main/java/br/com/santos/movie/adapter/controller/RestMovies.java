package br.com.santos.movie.adapter.controller;

import java.util.ArrayList;
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
	public ResponseEntity<List<List<MovieDTO>>> listWinners() {

		List<List<MovieDTO>> listWinner = new ArrayList<List<MovieDTO>>();

		var list = serviceMovie.listWinners();
		var listMin = serviceMovie.listWinnerMin(list)
				.stream()
				.map(MovieDTO::criar)
				.collect(Collectors.toList());

		var listMax = serviceMovie.listWinnerMax(list)
				.stream()
				.map(MovieDTO::criar)
				.collect(Collectors.toList());

		listWinner.add(listMin);
		listWinner.add(listMax);
		return ResponseEntity.ok(listWinner);
	}
}
