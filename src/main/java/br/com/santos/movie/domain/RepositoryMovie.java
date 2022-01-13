package br.com.santos.movie.domain;

import java.util.List;

import br.com.santos.movie.domain.model.Movie;

public interface RepositoryMovie {

	 void insert(List<Movie> list);
	 List<Movie> listWinners();
}
