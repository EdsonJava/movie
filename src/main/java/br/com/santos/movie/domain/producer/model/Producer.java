package br.com.santos.movie.domain.producer.model;

import java.util.List;

import br.com.santos.movie.domain.movie.model.Movie;
import lombok.Data;

@Data
public class Producer {

	private Long id;
	private String name;
	private List<Movie> movies;
	
}
