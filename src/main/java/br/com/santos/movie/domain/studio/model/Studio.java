package br.com.santos.movie.domain.studio.model;

import java.util.List;

import br.com.santos.movie.domain.movie.model.Movie;
import lombok.Data;

@Data
public class Studio {

	private Long id;
	private String name;
	private List<Movie> movies;
}
