package br.com.santos.filme.domain;

import java.util.List;

import br.com.santos.filme.domain.model.Movie;

public interface RepositoryMovie {

	 void insert(List<Movie> list);
	 List<Movie> listWinners();
}
