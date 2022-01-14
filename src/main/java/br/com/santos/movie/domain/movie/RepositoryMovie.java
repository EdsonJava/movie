package br.com.santos.movie.domain.movie;

import java.util.List;

import br.com.santos.movie.adapter.movie.repository.model.EntityMovie;
import br.com.santos.movie.domain.movie.model.Movie;

public interface RepositoryMovie {

	 List<EntityMovie> insert(List<Movie> list);
	 List<Movie> listWinners();
}
