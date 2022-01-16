package br.com.santos.movie.adapter.movie.controller;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santos.movie.adapter.movie.controller.model.MovieDTO;
import br.com.santos.movie.adapter.movie.controller.model.Root;
import br.com.santos.movie.domain.producer.ServiceProducer;
import lombok.AllArgsConstructor;

@RequestMapping("/movies")
@RestController
@AllArgsConstructor
public class RestMovies {

	private final ServiceProducer serviceProducer;

	@GetMapping("/awards")
	public ResponseEntity<Root> listWinners() {

		Root r = new Root();		
		var list = serviceProducer.findAllWinner();
		var min = serviceProducer.listWinnerMin(list)
				.stream()
				.map(MovieDTO::criar)
				.collect(Collectors.toList());
		r.setMin(min);
		
		var max = serviceProducer.listWinnerMax(list)
				.stream()
				.map(MovieDTO::criar)
				.collect(Collectors.toList());
		r.setMax(max);
	
		return ResponseEntity.ok(r);
	}
}
