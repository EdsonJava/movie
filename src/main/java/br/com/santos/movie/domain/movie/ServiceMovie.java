package br.com.santos.movie.domain.movie;

import java.util.List;

import br.com.santos.movie.domain.movie.modelo.Movie;
import br.com.santos.movie.domain.movie.modelo.MovieWinner;

public interface ServiceMovie {

	void insert(List<Movie> list);
	List<MovieWinner> listWinners();
	List<MovieWinner> listWinnerMin(List<MovieWinner> list);
	List<MovieWinner> listWinnerMax(List<MovieWinner> list);
	 
}
