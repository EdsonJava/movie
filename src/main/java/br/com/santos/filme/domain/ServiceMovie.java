package br.com.santos.filme.domain;

import java.util.List;

import br.com.santos.filme.domain.model.Movie;
import br.com.santos.filme.domain.model.MovieWinner;

public interface ServiceMovie {

	 void insert(List<Movie> list);
	 List<MovieWinner> listWinners();
	 
}
