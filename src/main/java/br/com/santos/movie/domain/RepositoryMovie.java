package br.com.santos.movie.domain;

import java.util.List;

import br.com.santos.movie.adapter.repository.model.EntityMovie;
import br.com.santos.movie.domain.model.Movie;

public interface RepositoryMovie {

	 List<EntityMovie> insert(List<Movie> list);
	 List<Movie> listWinners();
}
