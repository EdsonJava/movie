package br.com.santos.movie.domain;

import java.util.List;

import br.com.santos.movie.domain.model.Movie;
import br.com.santos.movie.domain.model.MovieWinner;

public interface ServiceMovie {

	void insert(List<Movie> list);
	List<MovieWinner> listWinners();
	List<MovieWinner> listWinnerMin(List<MovieWinner> list);
	List<MovieWinner> listWinnerMax(List<MovieWinner> list);
	 
}
